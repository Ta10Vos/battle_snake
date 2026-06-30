package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.enums.MoveType;
import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.evaluation.ShortestPath;
import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.BoardMap;
import nl.hu.bep.battlesnake.model.requests.EndRequest;
import nl.hu.bep.battlesnake.model.responses.MoveResponse;
import nl.hu.bep.battlesnake.util.ResourceManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/game/end")
public class EndResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response endGame(EndRequest request) {
        MapBuilder builder = new MapBuilder(request.board, request.you, true);

        BoardMap map = builder.getMap();
        ShortestPath pathFinder = new ShortestPath(map);
        MoveResult result = pathFinder.run(request.you.getHead(), request.board.getFood().get(0));
        result.calculateMoveType();
        String move = result.getMoveType().toString();

        ResourceManager.dumpMap(map);
        ResourceManager.mapDebug(map, result);

        return Response
                .ok()
                .entity(new MoveResponse(move, ""))
                .build();
    }
}

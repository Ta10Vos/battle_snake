package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.pathfinding.AStarPathFinder;
import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.BoardMap;
import nl.hu.bep.battlesnake.model.requests.StartRequest;
import nl.hu.bep.battlesnake.model.responses.MoveResponse;
import nl.hu.bep.battlesnake.util.ResourceManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/game/start")
public class StartResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startGame(StartRequest request) {
        MapBuilder builder = new MapBuilder(request.board, request.you, true);

        BoardMap map = builder.getMap();
        AStarPathFinder pathFinder = new AStarPathFinder(map);
        MoveResult result = pathFinder.run(request.you.getHead(), request.board.getFood().get(0));

        ResourceManager.dumpMap(map);
        ResourceManager.mapDebug(map, result);

        result.calculateMoveType();
        String move = result.getMoveType().toString();
        return Response
                .ok()
                .entity(new MoveResponse(move, ""))
                .build();
    }
}

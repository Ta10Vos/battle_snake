package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.evaluation.ShortestPath;
import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.requests.MoveRequest;
import nl.hu.bep.battlesnake.model.responses.MoveResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/game/move")
public class MoveResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(MoveRequest request) {
        MapBuilder builder = new MapBuilder(request.board, request.you, true);

        ShortestPath pathFinder = new ShortestPath(builder.getMap());
        MoveResult result = pathFinder.run(request.you.getHead(), request.board.getFood().get(0));
        String move = result.getMoveType().toString();
        return Response
                .ok()
                .entity(new MoveResponse(move, ""))
                .build();
    }
}

package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.enums.MoveType;
import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.evaluation.ShortestPath;
import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.BoardMap;
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

        BoardMap map = builder.getMap();
        ShortestPath pathFinder = new ShortestPath(map);
        MoveResult result = pathFinder.run(request.you.getHead(), request.board.getFood().get(0));

        System.out.println("SUCCESSFULLY CREATED A PATH:");
        System.out.println("TOTAL COST:" + result.getPathCost());
        System.out.println("PATH:\n---");
        System.out.println(result.getPath().toString());
        System.out.println("---");
        System.out.println("PATH MAP\n---------------");
        result.getPath().forEach(p -> map.get().get(p.y).get(p.x).setTileType(TileType.NONE));
        MapBuilder.logMap(map);
        System.out.println("---\nEND OF LOG");

        result.calculateMoveType();
        String move = result.getMoveType().toString();
        return Response
                .ok()
                .entity(new MoveResponse(move, ""))
                .build();
    }
}

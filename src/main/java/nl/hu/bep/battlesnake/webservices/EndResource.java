package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.model.Coordinate;
import nl.hu.bep.battlesnake.pathfinding.AStarPathFinder;
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
        return Response.ok().build();
    }
}

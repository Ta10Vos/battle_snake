package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.requests.MoveRequest;

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
        return Response.ok().build();
    }
}

package nl.hu.bep.battlesnake.webservices;

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

        return Response.ok().build();
    }
}

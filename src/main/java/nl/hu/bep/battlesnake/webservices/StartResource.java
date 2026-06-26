package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.requests.StartRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/game/start")
public class StartResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startGame(StartRequest request) {
        return Response.ok().build();
    }
}

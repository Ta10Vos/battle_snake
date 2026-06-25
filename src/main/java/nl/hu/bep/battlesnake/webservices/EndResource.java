package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.requests.EndRequest;

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

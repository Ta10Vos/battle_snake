package nl.hu.bep.webservices;

import nl.hu.bep.model.requests.EndRequest;
import nl.hu.bep.model.requests.MoveRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/end")
public class EndResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response endGame(EndRequest request) {
        return Response.ok().build();
    }
}

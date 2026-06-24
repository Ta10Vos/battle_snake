package nl.hu.bep.webservices;

import nl.hu.bep.model.requests.EndRequest;
import nl.hu.bep.model.requests.StartRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/start")
public class StartResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response endGame(StartRequest request) {
        return Response.ok().build();
    }
}

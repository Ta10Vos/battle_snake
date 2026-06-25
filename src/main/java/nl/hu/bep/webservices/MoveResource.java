package nl.hu.bep.webservices;

import nl.hu.bep.model.requests.MoveRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/move")
public class MoveResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(MoveRequest request) {
        return Response.ok().build();
    }
}

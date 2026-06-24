package nl.hu.bep.webservices;

import nl.hu.bep.model.requests.MoveRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

public class MoveResource {
    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(MoveRequest request) {
        
    }
}

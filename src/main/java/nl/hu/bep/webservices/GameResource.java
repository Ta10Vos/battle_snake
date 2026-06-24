package nl.hu.bep.webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/")
public class GameResource {
    @GET
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String move(MoveRequest request) {

    }
}

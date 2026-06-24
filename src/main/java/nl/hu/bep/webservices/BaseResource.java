package nl.hu.bep.webservices;

import nl.hu.bep.model.Customization;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/")
public class BaseResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomization() {
        return Response
                .status(Response.Status.OK)
                .entity(new Customization())
                .build();
    }
}

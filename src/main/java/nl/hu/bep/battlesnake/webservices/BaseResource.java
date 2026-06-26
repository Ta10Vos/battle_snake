package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.responses.BaseInformationResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class BaseResource {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIndex() {
        return Response.ok().build();
    }

    @GET
    @Path("/game")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomization() {
        return Response
                .status(Response.Status.OK)
                .entity(new BaseInformationResponse())
                .build();
    }
}

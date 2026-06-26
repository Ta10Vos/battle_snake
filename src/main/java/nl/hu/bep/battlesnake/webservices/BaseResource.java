package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.Customization;
import nl.hu.bep.battlesnake.model.responses.BaseInformationResponse;
import nl.hu.bep.battlesnake.model.responses.CustomizationResponse;
import nl.hu.bep.battlesnake.util.PersistenceManager;

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
        Customization customization = PersistenceManager.getCustomization();
        BaseInformationResponse baseInformationResponse = new BaseInformationResponse();

        baseInformationResponse.apiversion = "1";
        baseInformationResponse.author = "Ta10Vos";
        baseInformationResponse.version = "0.1.1-alpha";
        baseInformationResponse.color = customization.getColor();
        baseInformationResponse.head = customization.getHead();
        baseInformationResponse.tail = customization.getTail();

        return Response
                .status(Response.Status.OK)
                .entity(baseInformationResponse)
                .build();
    }
}

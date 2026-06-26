package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.Customization;
import nl.hu.bep.battlesnake.model.requests.CustomizationRequest;
import nl.hu.bep.battlesnake.model.responses.CustomizationResponse;
import nl.hu.bep.battlesnake.util.PersistenceManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("snake/")
public class SnakeResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomization() {
        Customization customization = PersistenceManager.getCustomization();
        return Response
                .status(Response.Status.OK)
                .entity(new CustomizationResponse(customization))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setCustomization(CustomizationRequest request) {
        Customization customization = new Customization(request);
        boolean result = PersistenceManager.saveCustomization(customization);

        if (result) {
            return Response.ok().build();
        } else {
            return Response
                    .status(500)
                    .entity(Map.of("message", "Something went wrong while saving customization."))
                    .build();
        }
    }
}

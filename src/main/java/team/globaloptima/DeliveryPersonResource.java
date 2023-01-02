package team.globaloptima;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
<<<<<<< HEAD
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
=======
>>>>>>> de5ec11b2a3a85cad62470b8cd24dc6234d6a920
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("delivery/people")
public class DeliveryPersonResource {

    @Inject
    DeliveryPersonService deliveryPersonBean;

    @GET
    @Operation(summary = "Get a list of delivery people", description = "Returns a list of all delivery people.")
    @APIResponses({
            @APIResponse(description = "List of delivery people", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = DeliveryPerson.class,
                            type = SchemaType.ARRAY)))
    })
    public Response getAllDeliveryPeople() {
        List<DeliveryPerson> deliveryPeople = deliveryPersonBean.getDeliveryPeople();
        return Response.ok(deliveryPeople).build();
    }

    @GET
    @Operation(summary = "Get delivery person details", description = "Return details of one delivery person with selected id")
    @APIResponses({
            @APIResponse(description = "Delivery Person", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = DeliveryPerson.class)))
    })
    @Path("{deliveryPersonId}")
    public Response getDeliveryPerson(@PathParam("deliveryPersonId") Integer deliveryPersonId) {
        DeliveryPerson deliveryPerson = deliveryPersonBean.getDeliveryPerson(deliveryPersonId);
        return deliveryPerson != null
                ? Response.ok(deliveryPerson).build()
                : Response.ok(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Operation(summary = "Create new Delivery person", description = "Create new delivery person")
    @APIResponses({
            @APIResponse(responseCode = "204",
                    description = "New customer created"
            )
    })
    public Response addNewDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPersonBean.addDeliveryPerson(deliveryPerson);
        return Response.noContent().build();
    }

    @DELETE
    @Operation(description = "Delete delivery person", summary = "Delete delivery person")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "Delivery person successfully deleted."
            )
    })
    @Path("{deliveryPersonId}")
    public Response deleteDeliveryPerson(@PathParam("deliveryPersonId") Integer deliveryPersonId) {
        deliveryPersonBean.deleteDeliveryPerson(deliveryPersonId);
        return Response.noContent().build();
    }
}

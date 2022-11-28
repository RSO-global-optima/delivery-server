package team.globaloptima;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("delivery/people")
public class DeliveryPersonResource {

    @GET
    public Response getAllDeliveryPeople() {
        List<DeliveryPerson> deliveryPeople = Database.getDeliveryPeople();
        return Response.ok(deliveryPeople).build();
    }

    @GET
    @Path("{deliveryPersonId}")
    public Response getDeliveryPerson(@PathParam("deliveryPersonId") Integer deliveryPersonId) {
        DeliveryPerson deliveryPerson = Database.getDeliveryPerson(deliveryPersonId);
        return Response.ok(Objects.requireNonNullElse(deliveryPerson, Response.Status.NOT_FOUND)).build();
    }

    @POST
    public Response addNewDeliveryPerson(DeliveryPerson deliveryPerson) {
        Database.addDeliveryPerson(deliveryPerson);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{deliveryPersonId}")
    public Response deleteDeliveryPerson(@PathParam("deliveryPersonId") Integer deliveryPersonId) {
        Database.deleteDeliveryPerson(deliveryPersonId);
        return Response.noContent().build();
    }
}

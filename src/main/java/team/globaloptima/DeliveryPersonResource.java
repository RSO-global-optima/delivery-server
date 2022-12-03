package team.globaloptima;

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
    public Response getAllDeliveryPeople() {
        List<DeliveryPerson> deliveryPeople = deliveryPersonBean.getDeliveryPeople();
        return Response.ok(deliveryPeople).build();
    }

    @GET
    @Path("{deliveryPersonId}")
    public Response getDeliveryPerson(@PathParam("deliveryPersonId") Integer deliveryPersonId) {
        DeliveryPerson deliveryPerson = deliveryPersonBean.getDeliveryPerson(deliveryPersonId);
        return deliveryPerson != null
                ? Response.ok(deliveryPerson).build()
                : Response.ok(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPersonBean.addDeliveryPerson(deliveryPerson);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{deliveryPersonId}")
    public Response deleteDeliveryPerson(@PathParam("deliveryPersonId") Integer deliveryPersonId) {
        deliveryPersonBean.deleteDeliveryPerson(deliveryPersonId);
        return Response.noContent().build();
    }
}

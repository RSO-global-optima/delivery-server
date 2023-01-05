package team.globaloptima;

import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import team.globaloptima.DeliveryPerson;

@Readiness
@ApplicationScoped
public class DatabaseHealthCheck implements HealthCheck {

    @PersistenceContext(unitName = "team-globaloptima-delivery-person")
    private EntityManager em;
    private static final Logger LOG = Logger.getLogger(DatabaseHealthCheck.class.getSimpleName());

    @Override
    public HealthCheckResponse call() {
        try {

            List<DeliveryPerson> deliveryPeople = em
                    .createNamedQuery("DeliveryPerson.findDeliveryPerson", DeliveryPerson.class)
                    .getResultList();

            if (deliveryPeople != null) {
                return HealthCheckResponse.up(DatabaseHealthCheck.class.getSimpleName());
            }
        } catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }
        return HealthCheckResponse.down(DatabaseHealthCheck.class.getSimpleName());
    }
}
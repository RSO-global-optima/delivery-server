import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class SuccessfulHealthCheckBean implements HealthCheck {

    public HealthCheckResponse call() {
        return HealthCheckResponse.up(SuccessfulHealthCheckBean.class.getSimpleName());
    }

}
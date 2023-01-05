import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class HTTPHealthCheck implements HealthCheck {

    private static final Logger LOG = Logger.getLogger(HTTPHealthCheck.class.getSimpleName());

    @Override
    public HealthCheckResponse call() {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://forward-reverse-geocoding.p.rapidapi.com/v1/forward?street=Litostrojska%2C7&city=Ljubljana")
                    .get()
                    .addHeader("X-RapidAPI-Key", "7ec20c098emshe16b98bd0d1f04cp1d97f8jsn3f0f050d99f7")
                    .addHeader("X-RapidAPI-Host", "forward-reverse-geocoding.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            if (response.code() == 200) {
                return HealthCheckResponse.up(HTTPHealthCheck.class.getSimpleName());
            }
        } catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }
        return HealthCheckResponse.down(HTTPHealthCheck.class.getSimpleName());
    }
}
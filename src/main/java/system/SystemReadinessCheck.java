/*
 * © 4/8/20, 7:00 PM. ivan
 */

package system;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class SystemReadinessCheck implements HealthCheck {
    private static final String SERVER_NAME = System.getProperty("wlp.server.name");

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named(SystemReadinessCheck.class.getSimpleName())
                .withData(SERVER_NAME, "available").up().build();
    }
}

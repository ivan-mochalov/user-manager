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
public class Health implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named(Health.class.getSimpleName())
                .withData("services", "available").up().build();
    }
}

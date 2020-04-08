/*
 * © 4/8/20, 8:49 PM. ivan
 */

package system;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Liveness
@ApplicationScoped
public class SystemLivenessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        long memUsed = memBean.getHeapMemoryUsage().getUsed();
        long memMax = memBean.getHeapMemoryUsage().getMax();

        return HealthCheckResponse.named(SystemLivenessCheck.class.getSimpleName())
                .withData("memory used", memUsed)
                .withData("memory max", memMax)
                .state(memUsed < memMax * 0.9).build();
    }
}

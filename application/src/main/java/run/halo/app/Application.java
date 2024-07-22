package run.halo.app;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import run.halo.app.infra.properties.HaloProperties;

/**
 * Halo main class.
 *
 * @author ryanwang
 * @author JohnNiang
 * @author guqing
 * @date 2017-11-14
 */
@Slf4j
@EnableScheduling
@SpringBootApplication(scanBasePackages = "run.halo.app", exclude =
    IntegrationAutoConfiguration.class)
@EnableConfigurationProperties({HaloProperties.class})
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
            .applicationStartup(new BufferingApplicationStartup(1024))
            .run(args);
        log.info("Halo started successfully.");
    }

}

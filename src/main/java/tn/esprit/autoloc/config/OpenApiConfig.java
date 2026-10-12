package tn.esprit.autoloc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "AutoLoc API",
                version = "v1",
                description = "REST API for vehicle rental management"
        )
)
public class OpenApiConfig {
}

package uz.pdp.olx.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi(){
        final String securitySchemeName = "Bearer Authentication";
        return new OpenAPI()
                .info(new Info()
                        .title("title")
                        .description("description")
                        .version("1.0.0")
                        .termsOfService("https://swagger.io")
                        .contact(new Contact()
                                .name("Escobar")
                                .email("escobar.vonn2002@gmail.com")
                                .url("https://github.com/escobar0007")
                        )

                ).addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName)
                ).components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name   (securitySchemeName)
                                .bearerFormat("JWT")
                                .scheme("bearer")
                                .type(SecurityScheme.Type.HTTP)
                        ));
    }
}

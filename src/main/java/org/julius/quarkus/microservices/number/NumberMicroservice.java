package org.julius.quarkus.microservices.number;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Number Microservice Title",
                description = "This microservice generates ISBN numbers for books",
                version = "1.0",
                contact = @Contact(name = "Julius", email = "quarkus@juliuslauterbach.de")
        ),
        externalDocs = @ExternalDocumentation(url = "https://github.com/Julius278/quarkus-rest-number-service")
)
public class NumberMicroservice extends Application {
}

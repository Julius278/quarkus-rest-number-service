package org.julius.quarkus.microservices.number;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

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

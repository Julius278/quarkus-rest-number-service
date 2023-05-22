package org.julius.quarkus.microservices.number;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name = "Number REST Endpoint")
public class NumberResource {

    @Inject
    Logger logger;

    @GET
    @Path("/random")
    @RequestScoped
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Generates random ISBN numbers for books", description = "some more description about ISBN10 and ISBN13 numbers")
    public IsbnNumbers getRandomIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn10("10-" + new Random().nextInt(1_000_000));
        isbnNumbers.setIsbn13("13-" + new Random().nextInt(100_000_000));
        isbnNumbers.setGenerationTime(Instant.now());

        logger.info("Endpoint getRandomIsbnNumbers generated: " + isbnNumbers.toString());

        return isbnNumbers;
    }
}
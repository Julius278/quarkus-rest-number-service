package org.julius.quarkus.microservices.number;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Path("/api/numbers")
@RequestScoped
@Tag(name = "Number REST Endpoint")
@Produces(MediaType.APPLICATION_JSON)
public class NumberResource {

    @Inject
    Logger logger;

    @GET
    @Path("/random")
    @Operation(summary = "Generates random ISBN numbers for books", description = "some more description about ISBN10 and ISBN13 numbers")
    public IsbnNumbers getRandomIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn10("10-" + new Random().nextInt(1_000_000));
        isbnNumbers.setIsbn13("13-" + new Random().nextInt(100_000_000));
        isbnNumbers.setGenerationTime(Instant.now());

        logger.info("Endpoint getRandomIsbnNumbers generated: " + isbnNumbers.toString());

        return isbnNumbers;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "just for testing purpose", description = "just for testing purpose")
    public Response saveRandomIsbnTenNumber(Optional<IsbnNumbers> isbn10) {

        logger.info("saveRandomIsbnTenNumber");

        IsbnNumbers isbnNumbers;

        if (isbn10.isPresent()) {
            isbnNumbers = new IsbnNumbers();

            IsbnNumbers isbnNumbers10 = isbn10.get();

            if (isbnNumbers10.getIsbn10() != null) {
                isbnNumbers.setIsbn10(isbnNumbers10.getIsbn10());
            }

            isbnNumbers.setIsbn13("nn");
            return Response.accepted(isbnNumbers).build();
        }
        return Response.status(415).build();
    }
}
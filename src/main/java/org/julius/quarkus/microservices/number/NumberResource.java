package org.julius.quarkus.microservices.number;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

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

    @GET
    @Path("/fix")
    @Operation(summary = "returns a fixed number", description = "returns a fixed number")
    public IsbnNumbers getFixedIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn10("10-1234567");
        isbnNumbers.setIsbn13("13-0123456789");
        isbnNumbers.setGenerationTime(Instant.now());

        logger.info("Endpoint getFixedIsbnNumbers: " + isbnNumbers.toString());

        return isbnNumbers;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "just for testing purpose", description = "just for testing purpose")
    @APIResponses(value = {
            @APIResponse(description = "accepted", responseCode = "202", name = "default"),
            @APIResponse(description = "unknown error", responseCode = "50x"),
            @APIResponse(description = "wrong input type", responseCode = "415")
    })
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
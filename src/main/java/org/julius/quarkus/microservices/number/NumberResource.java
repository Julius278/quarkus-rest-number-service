package org.julius.quarkus.microservices.number;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
public class NumberResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public IsbnNumbers getIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn10("10-" + new Random().nextInt(1_000_000));
        isbnNumbers.setIsbn13("13-" + new Random().nextInt(100_000_000));
        isbnNumbers.setGenerationTime(Instant.now());
        return isbnNumbers;
    }
}
package org.julius.quarkus.microservices.number;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;

@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testRandomIsbnNumbersEndpoint() {
        given()
          .when().get("/api/numbers/random")
          .then()
                .statusCode(200)
                .body("isbn10", startsWith("10-"))
                .body("isbn13", startsWith("13-"))
                .body(not(hasKey("generationDate")));
    }

}
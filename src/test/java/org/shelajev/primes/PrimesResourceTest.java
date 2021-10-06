package org.shelajev.primes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class PrimesResourceTest {

    @Test
    public void testRandomEndpoint() {
        given()
          .when().get("/primes/random/100")
          .then()
             .statusCode(200)
             .body(containsString("["));
    }

}
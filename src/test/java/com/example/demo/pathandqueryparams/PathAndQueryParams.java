package com.example.demo.pathandqueryparams;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class PathAndQueryParams {
    @Test
    void testQueryParams() {
                given()
                    .pathParam("myPath", "users")
                    .queryParam("page", 2)
                    .queryParam("id", 5)
                .when()
                    .get("https://reqres.in/api/{myPath}/12")
                .then()
                    .statusCode(200)
                    .log().all();
    }

}

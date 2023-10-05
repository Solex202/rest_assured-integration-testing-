package com.example.demo.schemavalidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class JsonSchemaValidation {

    @Test
    void testJsonSchemaValidation() {
//        ValidatableResponse body =
                given()

                .when()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

    }
}

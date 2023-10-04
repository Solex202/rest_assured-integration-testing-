package com.example.demo.pathandqueryparams;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class CookiesAndHeader {


    @Test
    void testCookies() {
        given()
        .when()
            .get("https://www.google.com")
        .then()
                .cookie("AEC","Ackid1T_oWYe1JsBjiQVd--LquBBfwjIrY-FZ5ttSJucIGbDnJCQYNkAIA4")
            .log().all();
    }
}

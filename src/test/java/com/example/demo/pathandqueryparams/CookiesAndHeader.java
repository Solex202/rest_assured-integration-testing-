package com.example.demo.pathandqueryparams;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.TestRunner.PriorityWeight.priority;

public class CookiesAndHeader {


    @Test()
    void testCookies() {
        HashMap<String, String> data = new HashMap<>();
//        data.put("firstName", "lota");
//        data.put("lastName", "chukwu");
        data.put("email", "onwukalotachukw@gmail.com");
        data.put("password", "@Chukwu123");
                given()
                    .contentType("application/json")
                    .body(data)
                .when()
//                    .post("http://172.16.0.150:8079/api/v2/user/signUp")
                        .post("https://api-enum-africa.herokuapp.com/api/v2/user/auth/login")

                .then()
                        .statusCode(200)
                        .log().all();
    }
}

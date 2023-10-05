package com.example.demo.one;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.TestRunner.PriorityWeight.priority;

public class HTTPRequest {

    int id ;

    @Test()

//    @Priority(1)
    void getUser(){
                given()
                .when()
                        .get("https://reqres.in/api/users/2")
                .then()
                        .statusCode(200)
                        .log().all();
    }

    @Test()
//    @Priority(2)
    void createUser(){
        HashMap <String, String> data = new HashMap<>();
        data.put("name", "morpheus");
        data.put("job", "programmer");

//        https://api-enum-africa.herokuapp.com/

              id =  given()
                        .contentType("application/json")
                        .body(data)
                .when()
                        .post("https://reqres.in/api/users")
                      .jsonPath().getInt("id");
//                .then()
//                        .statusCode(201)
//                        .log().all();
    }

    @Test()
//    @Priority(3,dependsOnMethods = "createUser")
    void updateUser(){
        HashMap <String, String> data = new HashMap<>();
        data.put("name", "lota");
        data.put("job", "teacher");
                given()
                    .contentType("application/json")
                    .body(data)
                .when()
                    .put("https://reqres.in/api/users/" + id)
                .then()
                    .statusCode(200).body("name", equalTo("lota"))
                    .log().all();
    }

    @Test
    void deleteUser(){
        given()
                .when()
                    .delete("https://reqres.in/api/users/" + id)
                .then()
                    .statusCode(204)
                    .log().all();
    }

    @Test

    void testPostRequestUsingExternalFile() throws FileNotFoundException {
        File file = new File(".\\data.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject jsonObject = new JSONObject(jsonTokener);

                given()
                        .contentType("application/json")
                        .body(jsonObject.toString())
                .when()
                        .post("https://reqres.in/api/users")
                .then()
                        .statusCode(201)
                        .log().all();
    }
}

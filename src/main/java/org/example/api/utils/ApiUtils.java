package org.example.api.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    // Sends GET request to the given endpoint
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.given()
                .when()
                .get(endpoint);
    }

    // Sends POST request with JSON body to the given endpoint
    public static Response sendPostRequest(String endpoint, Object requestBody) {
        return RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    // Sends PUT request with JSON body to the given endpoint
    public static Response sendPutRequest(String endpoint, Object requestBody) {
        return RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(endpoint);
    }

    // Sends DELETE request to the given endpoint
    public static Response sendDeleteRequest(String endpoint) {
        return RestAssured.given()
                .when()
                .delete(endpoint);
    }
}

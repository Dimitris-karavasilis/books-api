package org.example.api.api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        // Setup RestAssured base URI
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1";
    }
}
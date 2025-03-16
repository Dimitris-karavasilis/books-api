package org.example.api.api.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;

public class TestUtils {

//    @BeforeAll
//    public static void setupAllure() {
//        System.setProperty("allure.results.directory", "allure-results");
//    }

    public static String convertObjectToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to JSON", e);
        }
    }
}

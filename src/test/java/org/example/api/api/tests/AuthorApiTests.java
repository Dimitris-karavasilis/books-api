package org.example.api.api.tests;

import io.qameta.allure.Feature;
import org.example.api.utils.ApiUtils;
import org.example.api.models.Author;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Authors")
public class AuthorApiTests extends BaseTest {

    // Test case for GET /Authors - Retrieve all authors
    @Test
    public void testGetAuthors() {
        Response response = ApiUtils.sendGetRequest("/Authors");
        assertEquals(200, response.getStatusCode());
//        System.out.println(response.getBody().asString());
        assertTrue(response.getBody().asString().contains("First Name 1"));
    }

    // Test case for GET /Authors/{id} - Retrieve a specific author by ID
    @Test
    public void testGetAuthorById() {
        int authorId = 1; // Example author ID ,
        Response response = ApiUtils.sendGetRequest("/Authors/" + authorId);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("firstName"));
        assertTrue(response.getBody().asString().contains("lastName"));
    }

    // Test case for POST /Authors - Add a new author
    @Test
    public void testCreateAuthor() {
        Author newAuthor = new Author(0, 1, "John", "Doe");
        Response response = ApiUtils.sendPostRequest("/Authors", newAuthor);
        assertEquals(200, response.getStatusCode());

        // Optionally verify the response contains the newly created author
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("John"));
        assertTrue(responseBody.contains("Doe"));
    }

    // Test case for PUT /Authors/{id} - Update an existing author
    @Test
    public void testUpdateAuthor() {
        int authorId = 1; // Example author ID to update
        Author updatedAuthor = new Author(1,authorId, "Updated John", "Doe");
        Response response = ApiUtils.sendPutRequest("/Authors/" + authorId, updatedAuthor);
        assertEquals(200, response.getStatusCode());

        // Verify the updated author data in the response
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("Updated John"));
        assertTrue(responseBody.contains(String.valueOf(updatedAuthor.getidBook())));
    }

    // Test case for DELETE /Authors/{id} - Delete an author by ID
    @Test
    public void testDeleteAuthor() {
        int authorId = 1; // Example author ID to delete
        Response response = ApiUtils.sendDeleteRequest("/Authors/" + authorId);
        assertEquals(200, response.getStatusCode());

        // Verify the author is deleted by checking if they still exist
//        Response getResponse = ApiUtils.sendGetRequest("/Authors/" + authorId);
//        assertEquals(404, getResponse.getStatusCode()); // Author should not be found
        //mock site keeps returning 200
    }
}

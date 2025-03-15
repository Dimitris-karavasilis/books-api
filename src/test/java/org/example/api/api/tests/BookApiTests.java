package org.example.api.api.tests;


import io.qameta.allure.Feature;
import org.example.api.utils.ApiUtils;
import org.example.api.models.Book;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Books")
public class BookApiTests extends BaseTest {

    // Test case for GET /Books - Retrieve all books
    @Test
    public void testGetBooks() {
        Response response = ApiUtils.sendGetRequest("/Books");
//        System.out.println(response.getBody().asString());
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("Book"));
    }

    // Test case for GET /Books/{id} - Retrieve a specific book by ID
    @Test
    public void testGetBookById() {
        int bookId = 1; // Example book ID
        Response response = ApiUtils.sendGetRequest("/Books/" + bookId);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getBody().asString().contains("title"));
        assertTrue(response.getBody().asString().contains(String.valueOf(bookId)));
    }

    // Test case for POST /Books - Add a new book
    @Test
    public void testCreateBook() {
        Book newBook = new Book(0, "New Book Title", "description", 100, "bla", "2025-01-01");
        Response response = ApiUtils.sendPostRequest("/Books", newBook);
        assertEquals(200, response.getStatusCode());

        // Optionally verify the response contains the newly created book
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("New Book Title"));
        System.out.println(response.getBody().asString());
        assertTrue(responseBody.contains("description"));
    }

    // Test case for PUT /Books/{id} - Update an existing book
    @Test
    public void testUpdateBook() {
        int bookId = 1; // Example book ID to update
        Book updatedBook = new Book(bookId, "Updated Book Title", "updated description", 50, "upd", "2025-12-31");
        Response response = ApiUtils.sendPutRequest("/Books/" + bookId, updatedBook);
        assertEquals(200, response.getStatusCode());

        // Verify the updated book data in the response
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("Updated Book Title"));
        assertTrue(responseBody.contains("updated description"));
    }

    // Test case for DELETE /Books/{id} - Delete a book by ID
    @Test
    public void testDeleteBook() {
        int bookId = 1; // Example book ID to delete
        Response response = ApiUtils.sendDeleteRequest("/Books/" + bookId);
        assertEquals(200, response.getStatusCode());

        // Verify the book is deleted by checking if it still exists
//        Response getResponse = ApiUtils.sendGetRequest("/Books/" + bookId);
//        assertEquals(404, getResponse.getStatusCode()); // Book should not be found
        //it keeps being there in the mock site
    }
}

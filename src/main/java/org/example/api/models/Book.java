package org.example.api.models;

public class Book {
    private int id;
    private String title;
    private String description;
    private int pages;
    private String exc ;
    private String publishDate;

    // Constructor
    public Book(int id, String title, String description, int pages, String exc, String publishDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pages = pages;
        this.exc = exc;
        this.publishDate = publishDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() { return pages; }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getExc() {
        return exc;
    }

    public void seExc(String exc) {
        this.exc = exc;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}

package com.twu.biblioteca;

public class Book extends LibraryItem {

    private final String author;

    public Book(String title, int year, boolean checkedOut, String author) {
        super(title, year, checkedOut);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

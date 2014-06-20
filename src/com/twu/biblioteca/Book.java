package com.twu.biblioteca;

/**
 * Created by richiethomas on 6/17/14.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public Book(String title, String author, int year, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnBook() {
        checkedOut = false;
    }
}

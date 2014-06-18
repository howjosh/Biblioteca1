package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class BookListPrinter implements Printer {

    private PrintStream out;
    private String message;

    public BookListPrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void display() {
        out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by richiethomas on 6/17/14.
 */
public class WelcomeMessagePrinter implements Printer {

    private PrintStream out;
    private final String message = "Welcome to the library!";

    public WelcomeMessagePrinter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void display() {
    out.println(message);
  }
}

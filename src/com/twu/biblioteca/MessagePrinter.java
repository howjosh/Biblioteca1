package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by richiethomas on 6/17/14.
 */
public class MessagePrinter {

  private PrintStream out;
  private String message;

  public MessagePrinter(PrintStream out) {
    this.out = out;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void display() {
    out.println(message);
  }
}

package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by richiethomas on 6/17/14.
 */
public class WelcomeMessage {

  private PrintStream out;

  public WelcomeMessage(PrintStream out) {
    this.out = out;
  }

  public void display() {
    out.println("Welcome!");
  }

}

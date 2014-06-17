package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestWelcomeMessage {

  @Test
  public void testWelcomeMessage() {
    BibliotecaApp bibby = new BibliotecaApp();
    String welcome = bibby.welcome();
    assertEquals(welcome, "Welcome to the library.");
  }
}

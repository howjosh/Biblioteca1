package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


/**
 * Created by richiethomas on 6/17/14.
 */
public class TestWelcomeMessage {

  @Test
  public void testWelcomeMessage() {
    PrintStream printStream = mock(PrintStream.class);
    BiblioMessage message = new BiblioMessage(printStream);
    message.setMessage("Welcome!");
    message.display();
    verify(printStream).println("Welcome!");
  }
}

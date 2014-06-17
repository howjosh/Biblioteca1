package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import static org.mockito.Mockito.*;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestListBooks {

  @Test
  public void testListBooks(){
    BookList bookList = new BookList();
    PrintStream printStream = mock(PrintStream.class);
    BiblioMessage message = new BiblioMessage(printStream);


    message.setMessage(bookList.toString());
    message.display();
    verify(printStream).println("The Hobbit\nGoT\n");
  }
}

package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestListBooks {

  @Test
  public void testListBooks(){
    BibliotecaApp bibby = new BibliotecaApp();
    String[] allBooks = bibby.getAllBooks();
    String[] testBookList = new String[2];
    testBookList[0] = "The Hobbit";
    testBookList[1] = "Game of Thrones";

    assertEquals(allBooks,testBookList);
  }
}

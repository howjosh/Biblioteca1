package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestBooksList {

    Map<String,Book> bookList;

    @Before
    public void setUp(){
        bookList = new HashMap<String,Book>();
        bookList.put("Harry Potter", new Book("Harry Potter", "JK Rowling", 1995, false));
        bookList.put("The Shining", new Book("The Shining", "Stephen King", 1970, false));
    }

    @Test
    public void testListBooks(){
        BufferedReader reader = mock(BufferedReader.class);
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(printStream,reader,bookList);

        library.display();
        verify(printStream).println("The Shining                             |  Stephen King                            |  1970\n" +
                "Harry Potter                            |  JK Rowling                              |  1995\n");
    }

}


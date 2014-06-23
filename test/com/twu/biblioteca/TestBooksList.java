package com.twu.biblioteca;

import org.junit.Before;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestBooksList {

   List<LibraryItem> itemList;

    @Before
    public void setUp(){
        itemList = new ArrayList<LibraryItem>();
        itemList.add( new Book("Harry Potter", 1995, false, "JK Rowling"));
        itemList.add( new Book("The Shining", 1970, false, "Stephen King"));
    }


    public void testListBooks(){
        BufferedReader reader = mock(BufferedReader.class);
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(printStream,reader, itemList);

        library.displayBooks();
        verify(printStream).println("The Shining                             |  Stephen King                            |  1970\n" +
                "Harry Potter                            |  JK Rowling                              |  1995\n");
    }

}


package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestBooksList {

    @Test
    public void testListBooks(){

        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(printStream);

        library.display();
        verify(printStream).println("Harry Potter And The Prisoner of Azkaban|  JK Rowling                              |  1999\n" +
                "The Shining                             |  Steven King                             |  1980\n");
    }

}


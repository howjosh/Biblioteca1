package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class TestLibrary {


    private PrintStream printStream;
    private BufferedReader reader;
    Map<String,Book> bookList;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        bookList = new HashMap<String,Book>();
        bookList.put("Harry Potter", new Book("Harry Potter", "JK Rowling", 1995, false));
        bookList.put("The Shining", new Book("The Shining", "Stephen King", 1970, false));
    }

    @Test
    public void shouldRemoveBookFromBookListOnCheckout() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        BufferedReader reader = mock(BufferedReader.class);
        Map<String,Book> bookList = new HashMap<String,Book>();
        Book book = new Book("Harry Potter", "JK Rowling", 1995, false);
        bookList.put("Harry Potter", book);
        Library library = new Library(printStream,reader,bookList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkOutBook();

        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldDisplayErrorForUnavailableBooks() throws IOException {
        Library library = new Library(printStream, reader, bookList);
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.checkOutBook();
        verify(printStream).println("What is the title of the book? ");
        verify(printStream).println("That book is not available.");
    }


    @Test
    public void shouldDisplayCheckedOutBookMessageOnCheckout() throws IOException {
        Library library = new Library(printStream, reader, bookList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkOutBook();
        verify(printStream).println("What is the title of the book? ");
        verify(printStream).println("Thank you! Enjoy the book");
    }

}

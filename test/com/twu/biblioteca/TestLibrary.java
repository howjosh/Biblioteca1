package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class TestLibrary {


    private PrintStream printStream;
    private BufferedReader reader;
    List<LibraryItem> itemList;
    private Library library;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        itemList = new ArrayList<LibraryItem>();
        itemList.add( new Book("Harry Potter", 1995, false, "JK Rowling"));
        itemList.add(new Book("The Shining", 1970, false, "Stephen King"));

        library = new Library(printStream, reader, itemList);
    }


    public void shouldRemoveBookFromBookListOnCheckout() throws IOException {
        Book book = new Book("Harry Potter", 1995, false, "JK Rowling");
        List<LibraryItem> itemList = new ArrayList<LibraryItem>();
        itemList.add(book);

        Library library = new Library(printStream, reader, itemList);

        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkoutItem();

        assertThat(book.isCheckedOut(), is(false));
    }

    @Test
    public void shouldAddBookToBookListOnReturn() throws IOException {
        List<LibraryItem> itemList = new ArrayList<LibraryItem>();
        Book book = new Book("Harry Potter", 1995, true, "JK Rowling");
        itemList.add(book);

        Library library = new Library(printStream, reader, itemList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.returnItem();

        assertThat(book.isCheckedOut(), is(false));
    }

  /*  @Test
    public void shouldNotDisplayCheckedOutBooks() {
        int longestBook = "The Shining".length() + 4;
        int longestAuthor = "Stephen King".length() + 4;

        Book book = (Book)itemList.get("Harry Potter");
        book.checkOut();
        library.displayBooks();

        String format = "%-" + longestBook + "s" + "%-" + longestAuthor + "s" + "%s\n";
        verify(printStream, never()).printf(format, "Harry Potter", "JK Rowling", 1995);
    }*/

    @Test
    public void shouldDisplayErrorForUnavailableBooks() throws IOException {
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.checkoutItem();
        verify(printStream).println("What is the title of the item?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayErrorForCheckedOutBooks() throws IOException {

        when(reader.readLine()).thenReturn("Harry Potter").thenReturn("Harry Potter");
        library.checkoutItem();
        library.checkoutItem();

        verify(printStream, times(2)).println("What is the title of the item?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayCheckedOutBookMessageOnCheckout() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkoutItem();
        verify(printStream).println("What is the title of the item?");
        verify(printStream).println("Thank you! Enjoy the book");
    }

/*    @Test
    public void shouldDisplayReturnedBookMessageOnReturn() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        Book book = (Book)itemList.get("Harry Potter");
        book.checkOut();

        library.returnItem();
        verify(printStream).println("What is the title of the item?");
        verify(printStream).println("Thank you for returning the book");
    }*/

    @Test
     public void shouldDisplayErrorForBooksThatAreUnavailableToReturn() throws IOException {
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.returnItem();
        verify(printStream).println("What is the title of the item?");
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldDisplayErrorForBooksThatAreAlreadyReturned() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        library.returnItem();
        verify(printStream).println("What is the title of the item?");
        verify(printStream).println("That is not a valid book to return.");
    }


}

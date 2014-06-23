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
import static org.mockito.Mockito.*;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class TestLibrary {


    private PrintStream printStream;
    private BufferedReader reader;
    Map<String,LibraryItem> itemList;
    private Library library;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        itemList = new HashMap<String, LibraryItem>();
        itemList.put("Harry Potter", new Book("Harry Potter", 1995, false, "JK Rowling"));
        itemList.put("The Shining", new Book("The Shining", 1970, false, "Stephen King"));

        library = new Library(printStream, reader, itemList);
    }

    @Test
    public void shouldRemoveBookFromBookListOnCheckout() throws IOException {
        Book book = new Book("Harry Potter", 1995, false, "JK Rowling");
        Map<String, LibraryItem> itemList = new HashMap<String,LibraryItem>();
        itemList.put("Harry Potter", book);

        when(reader.readLine()).thenReturn("Harry Potter");

        Library library = new Library(printStream, reader, itemList);
        library.checkOutBook();

        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldAddBookToBookListOnReturn() throws IOException {
        Map<String,LibraryItem> itemList = new HashMap<String,LibraryItem>();
        Book book = new Book("Harry Potter", 1995, true, "JK Rowling");
        itemList.put("Harry Potter", book);

        Library library = new Library(printStream, reader, itemList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.returnBook();

        assertThat(book.isCheckedOut(), is(false));
    }

    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        int longestBook = "The Shining".length() + 4;
        int longestAuthor = "Stephen King".length() + 4;

        Book book = (Book)itemList.get("Harry Potter");
        book.checkOut();
        library.displayBooks();

        String format = "%-" + longestBook + "s" + "%-" + longestAuthor + "s" + "%s\n";
        verify(printStream, never()).printf(format, "Harry Potter", "JK Rowling", 1995);
    }

    @Test
    public void shouldDisplayErrorForUnavailableBooks() throws IOException {
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.checkOutBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayErrorForCheckedOutBooks() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        Book book = (Book)itemList.get("Harry Potter");
        book.checkOut();


        library.checkOutBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayCheckedOutBookMessageOnCheckout() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkOutBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldDisplayReturnedBookMessageOnReturn() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        Book book = (Book)itemList.get("Harry Potter");
        book.checkOut();

        library.returnBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("Thank you for returning the book");
    }

    @Test
     public void shouldDisplayErrorForBooksThatAreUnavailableToReturn() throws IOException {
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.returnBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldDisplayErrorForBooksThatAreAlreadyReturned() throws IOException {
        when(reader.readLine()).thenReturn("Harry Potter");
        library.returnBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That is not a valid book to return.");
    }


}

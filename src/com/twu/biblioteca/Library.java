package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Library {
    Map<String, LibraryItem> itemList;


    private PrintStream printStream;
    private BufferedReader reader;

    public Library(PrintStream printStream, BufferedReader reader, Map<String, LibraryItem> itemList) {
        this.itemList = itemList;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void displayBooks() {

        List<Book> bookList = new ArrayList<Book>();

        for(LibraryItem item : itemList.values())
            if(item instanceof Book)
                bookList.add((Book)item);


        int padding = 4;
        int maxTitleLength = returnLongestTitle(bookList) + padding;
        int maxAuthorLength = returnLongestAuthor(bookList) + padding;

        String format = "%-" + maxTitleLength + "s" + "%-" + maxAuthorLength + "s" + "%s\n";




        //populate the bookList



        for (Book book : bookList) {
            if (!book.isCheckedOut())
                printStream.printf(format, book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    private int returnLongestTitle(List<Book> bookList) {
        int maxTitleLength = 0;
        for (Book book : bookList) {
            if (!book.isCheckedOut() && book.getTitle().length() > maxTitleLength) {
                maxTitleLength = book.getTitle().length();
            }
        }
        return maxTitleLength;
    }

    private int returnLongestAuthor(List<Book> bookList) {
        int maxAuthorLength = 0;
        for (Book book : bookList) {
            if (!book.isCheckedOut() && book.getAuthor().length() > maxAuthorLength) {
                maxAuthorLength = book.getAuthor().length();
            }
        }
        return maxAuthorLength;
    }


    public void checkOutBook() throws IOException {
        Book book = findBook();
        if (book != null && !book.isCheckedOut()) {
            book.checkOut();
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }

    }

    public void returnBook() throws IOException {
        Book book = findBook();
        if (book != null && book.isCheckedOut()) {
            book.returnItem();
            printStream.println("Thank you for returning the book");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    private Book findBook() throws IOException {
        printStream.println("What is the title of the book?");
        String bookString = reader.readLine();

        if (itemList.containsKey(bookString))
            return (Book)itemList.get(bookString);
        else
            return null;
    }
}

package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Library {
    List<LibraryItem> checkedInList;
    List<LibraryItem> checkedoutList;

    private PrintStream printStream;

    LibraryHelper libraryHelper;

    public Library(PrintStream printStream, BufferedReader reader, List<LibraryItem> checkedInList) {
        this.checkedInList = checkedInList;
        this.printStream = printStream;

        checkedoutList = new ArrayList<LibraryItem>();
        libraryHelper = new LibraryHelper(printStream, reader, this.checkedInList, checkedoutList);
    }

    public void displayBooks() {

        List<Book> bookList = new ArrayList<Book>();

        for (LibraryItem item : checkedInList) {
            if (item instanceof Book)
                bookList.add((Book) item);
        }

        int padding = 4;
        int maxTitleLength = libraryHelper.returnLongestTitle(bookList) + padding;
        int maxAuthorLength = libraryHelper.returnLongestAuthor(bookList) + padding;

        String format = "%-" + maxTitleLength + "s" + "%-" + maxAuthorLength + "s" + "%s\n";

        for (Book book : bookList) {
            if (!book.isCheckedOut())
                printStream.printf(format, book.getTitle(), book.getAuthor(), book.getYear());
        }
    }


    public void checkoutItem() throws IOException {


        LibraryItem item = libraryHelper.findItem();

        if (item != null && checkedInList.contains(item)) {
            item.checkOut();
            checkedInList.remove(item);
            checkedoutList.add(item);

            printStream.println("Thank you! Enjoy the book.");
        } else {

            if(item == null)
                printStream.println("Item is null");

            else
                printStream.println("CheckedInList didn't contain the book.");
            printStream.println("That book is not available.");
        }

    }

    public void returnItem() throws IOException {


        LibraryItem item = libraryHelper.findItem();


        if (item != null && checkedoutList.contains(item)) {
            item.returnItem();
            printStream.println("Thank you for returning the book");
            checkedInList.add(item);
            checkedoutList.remove(item);
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }





}

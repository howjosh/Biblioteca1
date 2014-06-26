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
    private BufferedReader reader;

    public Library(PrintStream printStream, BufferedReader reader, List<LibraryItem> checkedInList) {
        this.checkedInList = checkedInList;
        this.printStream = printStream;
        this.reader = reader;

        checkedoutList = new ArrayList<LibraryItem>();
    }

    public void displayBooks() {

        List<Book> bookList = new ArrayList<Book>();

        for (LibraryItem item : checkedInList) {
            if (item instanceof Book)
                bookList.add((Book) item);
        }

        int padding = 4;
        int maxTitleLength = returnLongestTitle(bookList) + padding;
        int maxAuthorLength = returnLongestAuthor(bookList) + padding;

        String format = "%-" + maxTitleLength + "s" + "%-" + maxAuthorLength + "s" + "%s\n";

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


    public void checkoutItem() throws IOException {

        printStream.println("In checkoutItem()");
        LibraryItem item = findItem();

        if (item != null && checkedInList.contains(item)) {
            item.checkOut();
            checkedInList.remove(item);
            checkedoutList.add(item);

            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }

    }

    public void returnItem() throws IOException {


        LibraryItem item = findItem();


        if (item != null && checkedoutList.contains(item)) {
            item.returnItem();
            printStream.println("Thank you for returning the book");
            checkedInList.add(item);
            checkedoutList.remove(item);
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }


    private LibraryItem findItem() throws IOException {


        printStream.println("In findItem()");

        printStream.println("What is the title of the item?");
        String itemTitle = reader.readLine();

        for(LibraryItem item : checkedoutList)
            if (item.getTitle().equals(itemTitle))
                return item;


        for(LibraryItem item : checkedInList)
            if (item.getTitle().equals(itemTitle))
                return item;



        return null;

    }

}
    /*private LibraryItem findItem() throws IOException {

        printStream.println("What is the title of the item?");
        String itemName = reader.readLine();
        LibraryItem item = checkedInList.get(itemName);

        if(item != null)
            return item;

        else return checkedoutList.get(itemName);
    }
}*/

package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by joshuahowell on 6/26/14.
 */
public class LibraryHelper {

    private PrintStream printStream;
    private BufferedReader reader;
    List<LibraryItem> checkedInList, checkedoutList;


    public LibraryHelper(PrintStream printStream, BufferedReader reader, List<LibraryItem> checkedInList, List<LibraryItem> checkedoutList){
        this.printStream = printStream;
        this.reader = reader;
        this.checkedInList = checkedInList;
        this.checkedoutList = checkedoutList;
    }

    public int returnLongestTitle(List<Book> bookList) {
        int maxTitleLength = 0;

        for (Book book : bookList)
            if (!book.isCheckedOut() && book.getTitle().length() > maxTitleLength)
                maxTitleLength = book.getTitle().length();

        return maxTitleLength;
    }

    public int returnLongestAuthor(List<Book> bookList) {
        int maxAuthorLength = 0;


        for (Book book : bookList)
            if (!book.isCheckedOut() && book.getAuthor().length() > maxAuthorLength)
                maxAuthorLength = book.getAuthor().length();

        return maxAuthorLength;
    }





    public LibraryItem findItem() throws IOException {



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

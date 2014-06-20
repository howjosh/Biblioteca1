package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by richiethomas on 6/17/14.
 */
public class Library {
    Map<String,Book> bookList;

    private PrintStream printStream;
    private BufferedReader reader;

    public Library(PrintStream printStream, BufferedReader reader, Map<String, Book> bookList) {
        this.bookList = bookList;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
  public String toString(){
    String temp = "";
    for(Book book : bookList.values()){
        if(book.isCheckedOut()) continue;
        temp += outputOneLine(book.getTitle()) + "|  ";
        temp += outputOneLine(book.getAuthor()) + "|  ";
        temp += Integer.toString(book.getYear()) + "\n";
    }
    return temp;
  }

  private String outputOneLine(String str) {

    int lengthOfString;
    if(str.length() >= 40) {
      lengthOfString = 40;
    } else {
      lengthOfString = str.length();
    }
    return String.format("%-40s", str.substring(0, lengthOfString));
  }

    public void display() {
        printStream.println(this.toString());
    }

    public void checkOutBook() throws IOException {
        printStream.println("What is the title of the book? ");
        String bookString = reader.readLine();

        if(bookList.containsKey(bookString)){
            Book book = bookList.get(bookString);
            book.checkOut();
            printStream.println("Thank you! Enjoy the book");
        }
        else{
            printStream.println("That book is not available.");
        }

    }
}

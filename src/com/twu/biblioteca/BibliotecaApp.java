package com.twu.biblioteca;

public class BibliotecaApp {



  public static void main(String[] args) {

    MessagePrinter message = new MessagePrinter(System.out);
    String[] listOfBooks = {"The Hobbit", "GoT"};


    message.setMessage("Welcome to the library!");
    message.display();

    BookList bookList = new BookList();
    message.setMessage(bookList.toString());
    message.display();

  }

}

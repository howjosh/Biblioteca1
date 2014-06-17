package com.twu.biblioteca;

public class BibliotecaApp {

  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }

  public String welcome() {
    return "Welcome to the library.";
  }

  public String[] getAllBooks(){
    String[] allBooks = {"The Hobbit","Game of Thrones"};
    return allBooks;
  }
}

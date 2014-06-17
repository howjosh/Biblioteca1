package com.twu.biblioteca;

/**
 * Created by richiethomas on 6/17/14.
 */
public class BookList {
  String[] bookList = {"The Hobbit, by JRR Tolkien (1975)", "Game Of Thrones, by George RR Martin (2001)"};

  @Override
  public String toString(){
    String temp = "";
    for(String s : bookList){
      temp += s +"\n";
    }
    return temp;
  }
}

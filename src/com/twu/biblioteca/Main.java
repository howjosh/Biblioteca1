package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        List<LibraryItem> itemList = new ArrayList<LibraryItem>();
        itemList.add( new Book("Harry Potter", 1995, false, "JK Rowling"));
        itemList.add( new Book("The Shining", 1970, false, "Stephen King"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(System.out, reader, itemList);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        Command listBooksCommand = new ListBooksCommand(library);
        commands.put("list", listBooksCommand);
        commands.put("quit", new QuitCommand(System.out));
        commands.put("checkout", new CheckoutBookCommand(library));
        commands.put("return", new ReturnBookCommand(library));

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                commands);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(menu);
        bibliotechaApp.start();

  }

}

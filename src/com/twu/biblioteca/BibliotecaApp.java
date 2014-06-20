package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BibliotecaApp {

    CommandMenu commandMenu;

    public BibliotecaApp(CommandMenu commandMenu) {
        this.commandMenu = commandMenu;
    }

    public static void main(String[] args) throws IOException {

        BookList bookList = new BookList(System.out);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        Command listBooksCommand = new ListBooksCommand(bookList);
        commands.put("list", listBooksCommand);

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                commands);

        Library library = new Library(menu);
        library.start();

  }



}

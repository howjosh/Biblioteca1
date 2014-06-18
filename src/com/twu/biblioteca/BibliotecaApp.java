package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BibliotecaApp {

    Printer message;
    CommandMenu commandMenu;

    public BibliotecaApp(Printer messagePrinter, CommandMenu commandMenu) {
        this.message = messagePrinter;
        this.commandMenu = commandMenu;
    }

    public static void main(String[] args) {

        BookList bookList = new BookList(new BookListPrinter(System.out));

        HashMap<String,Command> commands = new HashMap<String, Command>();
        Command listCommand = new ListCommand(bookList);
        commands.put("list", listCommand);

        BibliotecaApp app = new BibliotecaApp(new WelcomeMessagePrinter(System.out),
                                              new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                                              commands));
        app.start();

  }

    public void start() {
        message.display();
        commandMenu.listOptions();
    }

}

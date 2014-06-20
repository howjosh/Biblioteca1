package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BibliotecaApp {

    Printer message;
    CommandMenu commandMenu;

    public BibliotecaApp(Printer messagePrinter, CommandMenu commandMenu) {
        this.message = messagePrinter;
        this.commandMenu = commandMenu;
    }

    public static void main(String[] args) throws IOException {

        BookList bookList = new BookList(System.out);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        Command listBooksCommand = new ListBooksCommand(bookList);
        commands.put("list", listBooksCommand);

        BibliotecaApp app = new BibliotecaApp(new WelcomeMessagePrinter(System.out),
                                              new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                                              commands));
        app.start();

  }

    public void start() throws IOException {
        message.display();
        commandMenu.listOptions();
        commandMenu.selectAndExecuteOption();
    }

}

package com.twu.biblioteca;

public class BibliotecaApp {

    MessagePrinter message;
    String[] listOfBooks = {"The Hobbit", "GoT"};
    CommandMenu commandMenu;

    public BibliotecaApp(MessagePrinter messagePrinter, CommandMenu commandMenu) {
        this.message = messagePrinter;
        this.commandMenu = commandMenu;
    }

    public static void main(String[] args) {

      BibliotecaApp app = new BibliotecaApp(new MessagePrinter(System.out),new CommandMenu(System.out));
      app.start();

  }

    public void start() {


        message.setMessage("Welcome to the library!");
        message.display();
        commandMenu.listOptions();


    }

}

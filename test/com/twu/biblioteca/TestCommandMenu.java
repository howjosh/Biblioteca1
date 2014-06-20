package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestCommandMenu {

    private PrintStream printStream;
    private BufferedReader reader;
    private CommandMenu commandMenu;
    Map<String,Book> bookList;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        bookList = new HashMap<String,Book>();
        bookList.put("Harry Potter", new Book("Harry Potter", "JK Rowling", 1995, false));
        bookList.put("The Shining", new Book("The Shining", "Stephen King", 1970, false));
    }

    @Test
    public void testWelcomeMessage() {
        commandMenu = new CommandMenu(printStream, reader,mock(HashMap.class));
        commandMenu.displayWelcome();
        verify(printStream).println("Welcome to the library!");
    }

    @Test
    public void shouldListAllMenuOptions() {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        Command command = mock(Command.class);
        commands.put("list", command);
        commandMenu = new CommandMenu(printStream, reader, commands);

        commandMenu.listOptions();
        verify(printStream).println("list");
    }

    @Test
    public void shouldAcceptAndExecuteCommand() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put("zzzz", command);
        when(reader.readLine()).thenReturn("zzzz");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand);
        verify(command).execute();
    }

    @Test
    public void shouldDisplayBookList() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(mock(PrintStream.class), reader, commands);
        Command command = new ListBooksCommand(new Library(printStream, reader, bookList));
        commands.put("list",command);
        when(reader.readLine()).thenReturn("list");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand);
        verify(printStream).println("The Shining                             |  Stephen King                            |  1970\n" +
                "Harry Potter                            |  JK Rowling                              |  1995\n");
    }

    @Test
    public void shouldDisplayInvalidOptionMessage() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put("zzzz", command);
        when(reader.readLine()).thenReturn("Invalid option");

        String userCommand = commandMenu.promptUser();
        commandMenu.executeCommand(userCommand);
        verify(printStream).println("Select a valid option");
    }

    @Test
    public void shouldInvalidOptionReturnFalse() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put("zzzz", command);
        when(reader.readLine()).thenReturn("Invalid option");

        String userCommand = commandMenu.promptUser();
        boolean validOption = commandMenu.executeCommand(userCommand);
        assertThat(validOption, is(false));
    }

    @Test
    public void shouldReturnTrueOnQuit() {
        Command quitCommand = new QuitCommand(printStream);
        boolean isQuit = quitCommand.execute();
        assertThat(isQuit, is(true));
    }

    @Test
    public void shouldCheckoutBookCommandAlterBookList() throws IOException {
        Library library = mock(Library.class);
        Command checkoutBookCommand = new CheckoutBookCommand(library);
        checkoutBookCommand.execute();
        verify(library).checkOutBook();
    }

    @Test
    public void shouldReturnBookCommandAlterBookList() throws IOException {
        Library library = mock(Library.class);
        Command returnBookCommand = new ReturnBookCommand(library);
        returnBookCommand.execute();
        verify(library).returnBook();
    }
    
}

package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

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

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
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

        commandMenu.selectAndExecuteOption();
        verify(command).execute();
    }

    @Test
    public void shouldDisplayBookList() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(mock(PrintStream.class), reader, commands);
        Command command = new ListBooksCommand(new Library(printStream));
        commands.put("list",command);
        when(reader.readLine()).thenReturn("list");

        commandMenu.selectAndExecuteOption();
        verify(printStream).println("Harry Potter And The Prisoner of Azkaban|  JK Rowling                              |  1999\n" +
                "The Shining                             |  Steven King                             |  1980\n");
    }

    @Test
    public void shouldDisplayInvalidOptionMessage() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put("zzzz", command);
        when(reader.readLine()).thenReturn("Invalid option");

        commandMenu.selectAndExecuteOption();
        verify(printStream).println("Select a valid option");
    }

    @Test
    public void shouldInvalidOptionReturnFalse() throws IOException {
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put("zzzz", command);
        when(reader.readLine()).thenReturn("Invalid option");

        boolean validOption = commandMenu.selectAndExecuteOption();
        assertThat(validOption, is(false));
    }
}

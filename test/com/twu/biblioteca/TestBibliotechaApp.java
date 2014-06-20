package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBibliotechaApp {

    @Test
    public void testStartCallsWelcomeAndMenu() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        Library library= new Library(commandMenu);
        library.start();
        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu).selectAndExecuteOption();

    }
}

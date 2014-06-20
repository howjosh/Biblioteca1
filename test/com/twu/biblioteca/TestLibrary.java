package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestLibrary {

    @Test
    public void testLibraryStartCallsWelcomeAndMenu() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        when(commandMenu.selectAndExecuteOption()).thenReturn(true);
        Library library= new Library(commandMenu);
        library.start();
        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu).selectAndExecuteOption();
    }
}

package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBibliotechaApp {

    @Test
    public void testLibraryStartCallsWelcomeAndMenu() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        when(commandMenu.promptUser()).thenReturn("list");
        when(commandMenu.executeCommand("list")).thenReturn(true);
        BibliotechaApp bibliotechaApp = new BibliotechaApp(commandMenu);
        bibliotechaApp.start();
        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu).promptUser();
        verify(commandMenu).executeCommand("list");
    }
}

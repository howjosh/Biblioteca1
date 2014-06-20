package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBibliotechaApp {

    @Test
    public void testStartCallsWelcomeAndMenu() throws IOException {
        CommandMenu commandMenu = mock(CommandMenu.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(commandMenu);
        bibliotecaApp.start();
        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu).selectAndExecuteOption();

    }
}

package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBibliotechaApp {

    @Test
    public void testStartCallsWelcomeAndMenu(){
        MessagePrinter messagePrinter = mock(MessagePrinter.class);
        CommandMenu commandMenu = mock(CommandMenu.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(messagePrinter,commandMenu);
        bibliotecaApp.start();
        verify(messagePrinter).setMessage("Welcome to the library!");
        verify(messagePrinter).display();
        verify(commandMenu).listOptions();


    }
}

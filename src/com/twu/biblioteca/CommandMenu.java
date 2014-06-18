package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class CommandMenu {
    private String[] commands = {"list"};

    private PrintStream printStream;

    public CommandMenu(PrintStream printStream) {
        this.printStream = printStream;
    }


    public void listOptions() {
        for (String command : commands) {
            printStream.println(command);
        }
    }
}

package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class CommandMenu {
    private HashMap<String, Command> commands;
    private PrintStream printStream;
    private BufferedReader reader;

    public CommandMenu(PrintStream printStream, BufferedReader reader, HashMap<String, Command> commands) {
        this.printStream = printStream;
        this.reader = reader;
        this.commands = commands;
    }


    public void listOptions() {
        for (String command : commands.keySet()) {
            printStream.println(command);
        }
    }

    public void selectAndExecuteOption() throws IOException {
        String input = reader.readLine();
        commands.get(input).execute();
    }
}

package com.twu.biblioteca;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class ListBooksCommand implements Command {
    private Library library;

    public ListBooksCommand(Library library) {
        this.library = library;
    }

    @Override
    public boolean execute() {
        library.displayBooks();
        return false;
    }
}

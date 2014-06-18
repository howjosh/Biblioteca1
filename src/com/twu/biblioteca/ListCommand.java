package com.twu.biblioteca;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class ListCommand implements Command {
    private BookList bookList;

    public ListCommand(BookList bookList) {
        this.bookList = bookList;
    }

    @Override
    public void execute() {
        bookList.toString();
    }
}

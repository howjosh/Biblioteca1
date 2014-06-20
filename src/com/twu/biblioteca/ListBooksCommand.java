package com.twu.biblioteca;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class ListBooksCommand implements Command {
    private BookList bookList;

    public ListBooksCommand(BookList bookList) {
        this.bookList = bookList;
    }

    @Override
    public void execute() {
        bookList.display();
    }
}

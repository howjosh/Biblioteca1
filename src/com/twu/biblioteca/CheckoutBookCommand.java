package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class CheckoutBookCommand implements Command {
    private Library library;

    public CheckoutBookCommand(Library library) {
        this.library = library;
    }

    @Override
    public boolean execute() {
        try {
            library.checkoutItem();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

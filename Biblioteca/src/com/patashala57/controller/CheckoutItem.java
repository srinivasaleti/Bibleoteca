package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.view.IO;

import java.util.Optional;

//Responsible for checkout an item from library
class CheckoutItem {

    final Library library;
    final IO consoleIO;

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String BOOKS = "Books::";

    CheckoutItem(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    void checkOut(Class<? extends LibraryItem> itemClass, String noItemsAvailable, String enterBooksNameToCheckout,
                  String successMessage, String unsucessMessage) {
        if (library.isEmpty(itemClass)) {
            this.consoleIO.println(noItemsAvailable);
            return;
        }
        this.consoleIO.print(enterBooksNameToCheckout);
        String bookName = consoleIO.getInput();
        displayMessageBasedOnResponse(library.checkoutItem(itemClass, bookName), successMessage, unsucessMessage);
    }

    private void displayMessageBasedOnResponse(Optional optional, String successMessage, String unsucessMessage) {
        if (optional.isPresent()) {
            this.consoleIO.println(successMessage);
        } else {
            this.consoleIO.println(unsucessMessage);
        }
    }

}

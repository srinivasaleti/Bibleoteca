package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.model.User;
import com.patashala57.view.IO;

import java.util.Optional;

//Responsible for checkout an item from library
class CheckoutItem {

    private final Library library;
    private final IO consoleIO;
    private final User currentUser;

    CheckoutItem(Library library, IO consoleIO, User user) {
        this.library = library;
        this.consoleIO = consoleIO;
        this.currentUser = user;
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

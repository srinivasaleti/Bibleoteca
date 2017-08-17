package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.model.User;
import com.patashala57.view.IO;

import java.util.Optional;

//Responsible for return an item to biblioteca
class ReturnItem {

    private final Library library;
    private final IO consoleIO;
    private final User currentUser;

    private static final String NOT_VALID_USER = "You are not a valid user to return this item";

    ReturnItem(Library library, IO consoleIO, User currentUser) {
        this.library = library;
        this.consoleIO = consoleIO;
        this.currentUser = currentUser;
    }

    void returnAItem(Class<? extends LibraryItem> itemClass, String enterItemMessage,
                     String successMessage, String unSuccessMessage) {
        this.consoleIO.print(enterItemMessage);
        String itemName = consoleIO.getInput();
        Optional<User> checkedOutUser = this.library.whoCheckedOut(itemName, itemClass);
        if (!checkedOutUser.isPresent()) {
            this.consoleIO.println(unSuccessMessage);
            return;
        }
        if (!checkedOutUser.get().equals(this.currentUser)) {
            this.consoleIO.println(NOT_VALID_USER);
            return;
        }
        returnGivenBook(itemClass, itemName, successMessage);
    }

    private void returnGivenBook(Class<? extends LibraryItem> itemClass, String itemName, String successMessage) {
        if (this.library.returnItem(itemClass, itemName, this.currentUser)) {
            this.consoleIO.println(successMessage);
        }
    }

}

package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.view.IO;

//Responsible for return an item to biblioteca
class ReturnItem {

    private final Library library;
    private final IO consoleIO;

    ReturnItem(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    void returnAItem(Class<? extends LibraryItem> itemClass, String enterItemMessage,
                     String successMessage, String unSuccessMessage) {
        this.consoleIO.print(enterItemMessage);
        String bookName = consoleIO.getInput();
        boolean isSuccessfulReturn = this.library.returnItem(itemClass, bookName);
        if (isSuccessfulReturn) {
            this.consoleIO.println(successMessage);
            return;
        }
        this.consoleIO.println(unSuccessMessage);
    }

}

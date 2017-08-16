package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible form listing all items in library
class ListItems {

    private final Library library;
    private final IO consoleIO;

    ListItems(Library library, IO io) {
        this.library = library;
        this.consoleIO = io;
    }

    void listAll(Class<? extends LibraryItem> itemClass,String noItemsAvailable,String itemType,String header) {
        if (this.library.isEmpty(itemClass)) {
            this.consoleIO.println(noItemsAvailable);
            return;
        }
        this.consoleIO.println(itemType);
        this.consoleIO.println(header);
        this.consoleIO.println(library.stringRepresentationOfItems(itemClass));
    }


}

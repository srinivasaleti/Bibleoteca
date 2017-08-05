package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.view.IO;

import java.util.Optional;

//Responsible for checkout books from library
public class CheckoutBookCommand implements Command {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String ENTER_BOOK_NAME_TO_CHECK_OUT = "Enter a Book Name to check Out::";
    private static final String SUCCESS_MESSAGE = "Thank you! Enjoy the book";
    private static final String UNSUCCESS_MESSAGE = "That book is not available";

    private final Library library;
    private final IO consoleIO;

    CheckoutBookCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    @Override
    public void execute() {
        if (library.isEmpty(Book.class)) {
            consoleIO.println(NO_BOOK_AVAILABLE_MESSAGE);
            return;
        }
        consoleIO.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
        String bookName = consoleIO.getInput();
        displayMessageBasedOnOutCome(library.checkoutItem(Book.class, bookName));
    }

    private void displayMessageBasedOnOutCome(Optional<LibraryItem> item) {
        if (item.isPresent()) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}

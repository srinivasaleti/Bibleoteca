package com.patashala57;

import java.util.Optional;

//Responsible for checkout books from library
class CheckoutBookCommand implements Command {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String ENTER_BOOK_NAME_TO_CHECK_OUT = "Enter a Book Name to check Out::";
    private static final String SUCCESS_MESSAGE = "Thank you! Enjoy the book";
    private static final String UNSUCCESS_MESSAGE = "That book is not available";

    private Library library;
    private IO consoleIO;

    CheckoutBookCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    @Override
    public void execute() {
        if (library.isNoItemsAvailable(Book.class)) {
            consoleIO.println(NO_BOOK_AVAILABLE_MESSAGE);
            return;
        }
        consoleIO.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
        String bookName = consoleIO.getInput();
        displayMessage(library.checkoutItem(Book.class, bookName));
    }

    private void displayMessage(Optional<LibraryItem> item) {
        if (item.isPresent()) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}

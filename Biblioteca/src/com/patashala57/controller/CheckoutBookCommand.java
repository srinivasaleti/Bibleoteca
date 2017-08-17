package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.User;
import com.patashala57.view.IO;

//Responsible for checkout books from library
public class CheckoutBookCommand extends CheckoutItem implements Command {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String ENTER_BOOK_NAME_TO_CHECK_OUT = "Enter a Book Name to check Out::";
    private static final String SUCCESS_MESSAGE = "Thank you! Enjoy the book";
    private static final String UNSUCCESS_MESSAGE = "That book is not available";

    CheckoutBookCommand(Library library, IO consoleIO, User currenterUser) {
        super(library, consoleIO, currenterUser);
    }

    @Override
    public void execute() {
        checkOut(Book.class, NO_BOOK_AVAILABLE_MESSAGE, ENTER_BOOK_NAME_TO_CHECK_OUT, SUCCESS_MESSAGE, UNSUCCESS_MESSAGE);
    }

}

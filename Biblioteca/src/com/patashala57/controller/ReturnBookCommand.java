package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;

//Responsible to ReturnBook to bibiloteca
public class ReturnBookCommand extends ReturnItem implements Command {

    private static final String ENTER_BOOK_NAME = "Enter Book Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the book";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid book to return";

    ReturnBookCommand(Library library, IO consoleIO) {
        super(library,consoleIO);
    }

    @Override
    public void execute() {
        super.returnAItem(Book.class, ENTER_BOOK_NAME,SUCCESS_MESSAGE,UNSUCCESS_MESSAGE);
    }

}

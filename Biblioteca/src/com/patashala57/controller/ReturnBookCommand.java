package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;

//Responsible to ReturnBook to bibiloteca
public class ReturnBookCommand implements Command {

    private static final String ENTER_BOOK_Name = "Enter Book Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the book";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid book to return";

    private final Library library;
    private final IO consoleIO;

    ReturnBookCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    @Override
    public void execute() {
        this.consoleIO.print(ENTER_BOOK_Name);
        String bookName = consoleIO.getInput();
        boolean isSuccessfulReturn = this.library.returnItem(Book.class, bookName);
        this.displayMessageBasedOnReturnItemOutcome(isSuccessfulReturn);
    }

    private void displayMessageBasedOnReturnItemOutcome(boolean isReturn) {
        if (isReturn) {
            this.consoleIO.println(SUCCESS_MESSAGE);
        } else {
            this.consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}

package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.view.IO;

//Represents factory which gives a command that is associated with input
public class CommandFactoryAfterLogin implements Factory {

    private static final String LIST_BOOKS = "1";
    private static final String CHECKOUT_BOOK = "2";
    private static final String QUIT = "quit";
    private static final String RETURN_BOOK = "3";
    private static final String LIST_MOVIES = "4";
    private static final String CHECKOUT_MOVIE = "5";
    private static final String RETURN_MOVE = "6";

    private final IO consoleIO;
    private final Library library;

    public CommandFactoryAfterLogin(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    @Override
    public Command getCommand(String commandString) {
        if (commandString.equals(LIST_BOOKS)) {
            return new ListBooksCommand(library, consoleIO);
        }
        if (commandString.equals(CHECKOUT_BOOK)) {
            return new CheckoutBookCommand(library, consoleIO);
        }
        if (commandString.equals(RETURN_BOOK)) {
            return new ReturnBookCommand(library, consoleIO);
        }
        if (commandString.equals(LIST_MOVIES)) {
            return new ListMoviesCommand(library, consoleIO);
        }
        if (commandString.equals(CHECKOUT_MOVIE)) {
            return new CheckoutMovieCommand(library, consoleIO);
        }
        if (commandString.equals(RETURN_MOVE)) {
            return new ReturnMovieCommand(library, consoleIO);
        }
        if (commandString.equals(QUIT)) {
            return new QuitCommand(consoleIO);
        }
        return new InvalidCommand(consoleIO);
    }

}

package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.view.*;

import java.util.HashMap;
import java.util.Map;

//Represents factory which gives a command that is associated with input
public class CommandFactory implements Factory {

    private Map<String, Command> commandMap;
    private static final String LIST_BOOKS = "1";
    private static final String CHECKOUT_BOOK = "2";
    private static final String QUIT = "quit";
    private static final String RETURN_BOOK = "3";
    private static final String LIST_MOVIES = "4";
    private static final String CHECKOUT_MOVIE = "5";
    private static final String RETURN_MOVE = "6";

    private final IO consoleIO;
    private final Library library;

    public CommandFactory(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
        this.commandMap = new HashMap<>();
        this.loadCommands();
    }

    @Override
    public Command getCommand(String commandString) {
        if (this.commandMap.containsKey(commandString)) {
            return this.commandMap.get(commandString);
        } else {
            return new InvalidCommand(consoleIO);
        }
    }

    @Override
    public void loadCommands() {
        this.commandMap.put(LIST_BOOKS, new ListBooksCommand(library, consoleIO));
        this.commandMap.put(CHECKOUT_BOOK, new CheckoutBookCommand(library, consoleIO));
        this.commandMap.put(RETURN_BOOK, new ReturnBookCommand(library, consoleIO));
        this.commandMap.put(LIST_MOVIES, new ListMoviesCommand(library, consoleIO));
        this.commandMap.put(CHECKOUT_MOVIE, new CheckoutMovieCommand(library, consoleIO));
        this.commandMap.put(RETURN_MOVE, new ReturnMovieCommand(library, consoleIO));
        this.commandMap.put(QUIT, new QuitCommand(consoleIO));
    }

}

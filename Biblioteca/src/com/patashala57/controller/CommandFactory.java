package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.view.*;

import java.util.HashMap;
import java.util.Map;

//Represents factory which gives a command that is associated with input
public class CommandFactory implements Factory {

    private static Map<String, Command> commandMap;
    private static final String LIST_BOOKS = "1";
    private static final String CHECKOUT_BOOK = "2";
    private static final String QUIT = "quit";
    private static final String RETURN_BOOK = "3";
    private static final String LIST_MOVIES = "4";
    private static final String CHECKOUT_MOVIE = "5";
    private static final String RETURN_MOVE = "6";

    private final IO io;
    private final Library library;

    public CommandFactory(Library library, IO io) {
        this.library = library;
        this.io = io;
        this.loadCommands();
    }

    @Override
    public Command getCommand(String commandString) {
        if (commandMap.containsKey(commandString)) {
            return commandMap.get(commandString);
        } else {
            return new InvalidCommand(io);
        }
    }

    @Override
    public void loadCommands() {
        commandMap = new HashMap<>();
        commandMap.put(LIST_BOOKS, new ListBooksCommand(library, io));
        commandMap.put(CHECKOUT_BOOK, new CheckoutBookCommand(library, io));
        commandMap.put(RETURN_BOOK, new ReturnBookCommand(library, io));
        commandMap.put(LIST_MOVIES, new ListMoviesCommand(library, io));
        commandMap.put(CHECKOUT_MOVIE, new CheckoutMovieCommand(library, io));
        commandMap.put(RETURN_MOVE, new ReturnMovieCommand(library, io));
        commandMap.put(QUIT, new QuitCommand(io));
    }

}

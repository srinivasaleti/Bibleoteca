package com.patashala57;

import java.util.HashMap;
import java.util.Map;

//Represents maping between String to command
class CommandFactory implements Factory {

    private static Map<String, Command> commandMap;
    private static final String LIST_BOOKS = "1";
    private static final String CHECKOUT_BOOK = "2";
    private static final String QUIT = "quit";
    private static final String RETURN_BOOK = "3";
    private static final String LIST_MOVIES = "4";
    private static final String CHECKOUT_MOVIE = "5";
    private static final String RETURN_MOVE = "6";

    private IO io;
    private Biblioteca biblioteca;

    CommandFactory(Biblioteca biblioteca, IO io) {
        this.biblioteca = biblioteca;
        this.io = io;
        this.loadMaps();
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
    public void loadMaps() {
        commandMap = new HashMap<>();
        commandMap.put(LIST_BOOKS, new ListBooksCommand(biblioteca, io));
        commandMap.put(CHECKOUT_BOOK, new CheckoutBookCommand(biblioteca, io));
        commandMap.put(RETURN_BOOK, new ReturnBookCommand(biblioteca, io));
        commandMap.put(LIST_MOVIES, new ListMoviesCommand(biblioteca, io));
        commandMap.put(CHECKOUT_MOVIE, new CheckoutMovieCommand(biblioteca, io));
        commandMap.put(RETURN_MOVE, new ReturnMovieCommand(biblioteca, io));
        commandMap.put(QUIT, new QuitCommand(io));
    }

}

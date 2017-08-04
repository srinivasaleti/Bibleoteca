package com.patashala57;

import java.util.HashMap;
import java.util.Map;

//Represents maping between String to command
class CommandFactory {

    private static Map<String,Command> factory;
    private static final String LIST_BOOKS = "1";
    private static final String CHECKOUT_BOOK = "2";
    private static final String QUIT = "quit";
    private static final String RETURN_BOOK = "3";
    private static final String LIST_MOVIES="4";
    private static final String CHECKOUT_MOVIE="5";
    private static final String RETURN_MOVE = "6";

    private IO io;
    CommandFactory(Biblioteca biblioteca,IO io){
        this.io=io;
        factory=new HashMap<>();
        factory.put(LIST_BOOKS,new ListBooksCommand(biblioteca,io));
        factory.put(CHECKOUT_BOOK,new CheckoutBookCommand(biblioteca,io));
        factory.put(RETURN_BOOK,new ReturnBookCommand(biblioteca,io));
        factory.put(LIST_MOVIES,new ListMoviesCommand(biblioteca,io));
        factory.put(CHECKOUT_MOVIE,new CheckoutMovieCommand(biblioteca,io));
        factory.put(RETURN_MOVE,new ReturnMovieCommand(biblioteca,io));
        factory.put(QUIT,new QuitCommand(io));
    }

    Command getCommand(String commandString){
        if(factory.containsKey(commandString)) {
            return factory.get(commandString);
        }
        else{
            return new InvalidCommand(io);
        }
    }

}

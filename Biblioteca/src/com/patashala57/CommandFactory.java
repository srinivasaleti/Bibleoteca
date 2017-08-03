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

    static {
        factory=new HashMap<>();
        factory.put(LIST_BOOKS,new ListBooksCommand());
        factory.put(CHECKOUT_BOOK,new CheckOutBook());
        factory.put(RETURN_BOOK,new ReturnBookCommand());
        factory.put(LIST_MOVIES,new ListMoviesCommand());
        factory.put(CHECKOUT_MOVIE,new CheckOutMovieCommand());
        factory.put(QUIT,new QuitCommand());
    }

    static Command getCommand(String commandString){
        if(factory.containsKey(commandString)) {
            return factory.get(commandString);
        }
        else{
            return new InvalidCommand();
        }
    }

}

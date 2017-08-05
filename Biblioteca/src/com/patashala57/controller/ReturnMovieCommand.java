package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

public class ReturnMovieCommand implements Command {

    private static final String ENTER_MOVIE_NAME = "Enter Movie Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the Movie";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid Movie to return";

    private final Library library;
    private final IO consoleIO;

    ReturnMovieCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    @Override
    public void execute() {
        consoleIO.print(ENTER_MOVIE_NAME);
        String movieName = consoleIO.getInput();
        boolean isReturn = library.returnItem(Movie.class, movieName);
        displayMessageBasedOnReturnItemOutcome(isReturn);
    }

    private void displayMessageBasedOnReturnItemOutcome(boolean isReturn) {
        if (isReturn) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}

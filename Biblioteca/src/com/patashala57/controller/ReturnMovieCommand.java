package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.model.User;
import com.patashala57.view.IO;


//Responsible for return a movie from biblioteca
public class ReturnMovieCommand extends ReturnItem implements Command {

    private static final String ENTER_MOVIE_NAME = "Enter Movie Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the Movie";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid Movie to return";

    ReturnMovieCommand(Library library, IO consoleIO, User currentUser) {
        super(library,consoleIO, currentUser);
    }

    @Override
    public void execute() {
        super.returnAItem(Movie.class,ENTER_MOVIE_NAME,SUCCESS_MESSAGE,UNSUCCESS_MESSAGE);
    }

}

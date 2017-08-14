package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible for checkout movies from library
public class CheckoutMovieCommand extends CheckoutItem implements Command {

    private static final String NO_MOVIE_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String ENTER_MOVIE_NAME_TO_CHECK_OUT = "Enter a Movie Name to check Out::";
    private static final String SUCCESS_MESSAGE = "Thank You Enjoy the Movie";
    private static final String UNSUCCESS_MESSAGE = "That Movie is not available";


    CheckoutMovieCommand(Library library, IO consoleIO) {
        super(library, consoleIO);
    }

    @Override
    public void execute() {
        super.checkOut(Movie.class, NO_MOVIE_AVAILABLE_MESSAGE, ENTER_MOVIE_NAME_TO_CHECK_OUT,
                SUCCESS_MESSAGE, UNSUCCESS_MESSAGE);
    }

}
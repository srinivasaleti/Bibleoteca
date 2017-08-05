package com.patashala57.view;

import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.model.Movie;

import java.util.Optional;

//Responsible for checkout movies from library
public class CheckoutMovieCommand implements Command {

    private static final String NO_MOVIE_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String ENTER_MOVIE_NAME_TO_CHECK_OUT = "Enter a Movie Name to check Out::";
    private static final String SUCCESS_MESSAGE = "Thank You Enjoy the Movie";
    private static final String UNSUCCESS_MESSAGE = "That Movie is not available";

    private Library library;
    private IO consoleIO;

    public CheckoutMovieCommand(Library library, IO consoleIO){
        this.library = library;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        if (library.isNoItemsAvailable(Movie.class)) {
            consoleIO.println(NO_MOVIE_AVAILABLE_MESSAGE);
            return;
        }
        consoleIO.print(ENTER_MOVIE_NAME_TO_CHECK_OUT);
        String movieName = consoleIO.getInput();
        displayMessage(library.checkoutItem(Movie.class,movieName));
    }

    private void displayMessage(Optional<LibraryItem> item) {
        if (item.isPresent()) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}
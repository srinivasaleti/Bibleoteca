package com.patashala57;

import java.util.Optional;

//Responsible for checkout movies from biblioteca
class CheckoutMovieCommand implements Command {

    private static final String NO_MOVIE_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String ENTER_MOVIE_NAME_TO_CHECK_OUT = "Enter a Movie Name to check Out::";
    private static final String SUCCESS_MESSAGE = "Thank You Enjoy the Movie";
    private static final String UNSUCCESS_MESSAGE = "That Movie is not available";

    private Biblioteca biblioteca;
    private IO consoleIO;

    CheckoutMovieCommand(Biblioteca biblioteca, IO consoleIO){
        this.biblioteca=biblioteca;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        if (biblioteca.isNoItemsAvailable(Movie.class)) {
            consoleIO.println(NO_MOVIE_AVAILABLE_MESSAGE);
            return;
        }
        consoleIO.print(ENTER_MOVIE_NAME_TO_CHECK_OUT);
        String movieName = consoleIO.getInput();
        displayMessage(biblioteca.checkoutItem(Movie.class,movieName));
    }

    private void displayMessage(Optional<LibraryItem> item) {
        if (item.isPresent()) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}
package com.patashala57.view;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;

//Responsible for list moveis in biblioteca
public class ListMoviesCommand implements Command {

    private static final String NO_MOVIES_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String MOVIES = "Movies::";

    private Library biblioteca;
    private IO consoleIO;

    public ListMoviesCommand(Library library, IO consoleIO) {
        this.biblioteca=library;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        if(biblioteca.isNoItemsAvailable(Movie.class)){
            consoleIO.println(NO_MOVIES_AVAILABLE_MESSAGE);
            return;
        }
        consoleIO.println(MOVIES);
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);
        consoleIO.println(header);
        consoleIO.println(biblioteca.stringRepresentationOfItems(Movie.class));
    }

}

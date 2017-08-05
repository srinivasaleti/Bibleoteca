package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible for list movies in Bibloteca
public class ListMoviesCommand implements Command {

    private static final String NO_MOVIES_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String MOVIES = "Movies::";

    private final Library library;
    private final IO consoleIO;

    ListMoviesCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO = consoleIO;
    }

    @Override
    public void execute() {
        if (this.library.isEmpty(Movie.class)) {
            this.consoleIO.println(NO_MOVIES_AVAILABLE_MESSAGE);
            return;
        }
        this.consoleIO.println(MOVIES);
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);
        this.consoleIO.println(header);
        this.consoleIO.println(library.stringRepresentationOfItems(Movie.class));
    }

}

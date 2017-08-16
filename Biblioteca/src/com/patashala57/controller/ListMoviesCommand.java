package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible for list movies in Bibloteca
public class ListMoviesCommand extends ListItems implements Command {

    private static final String NO_MOVIES_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String MOVIES = "Movies::";

    ListMoviesCommand(Library library, IO consoleIO) {
        super(library,consoleIO);
    }

    @Override
    public void execute() {
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);
        super.listAll(Movie.class,NO_MOVIES_AVAILABLE_MESSAGE,MOVIES,header);
    }

}

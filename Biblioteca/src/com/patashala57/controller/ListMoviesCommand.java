package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible for list movies in Bibloteca
public class ListMoviesCommand extends ListItems implements Command {

    ListMoviesCommand(Library library, IO consoleIO) {
        super(library,consoleIO);
    }

    @Override
    public void execute() {
        super.listAll(Movie.class);
    }

}

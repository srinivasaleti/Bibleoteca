package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListMoviesCommandTest {
    private IO mockIO;
    private Library library;
    private ListMoviesCommand listMoviesCommand;

    @BeforeEach
    void beforeEach() {
        this.library = mock(Library.class);
        this.mockIO = mock(IO.class);
        this.listMoviesCommand = new ListMoviesCommand(this.library, this.mockIO);
    }

    @Test
    void displayNoMoviesAvailable() {
        when(this.library.isEmpty(Movie.class)).thenReturn(true);
        this.listMoviesCommand.execute();
        String noMoviesAvailable = "No Movies Available";

        verify(this.mockIO).println(noMoviesAvailable);
    }

    @Test
    void displayHeader() {
        String movies = "Movies::";
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        this.listMoviesCommand.execute();

        verify(this.mockIO).println(movies);
        verify(this.mockIO).println(header);
    }

    @Test
    void displayMoviesInBiblioteca() {
        String name = "Titanic";
        int yearReleased = 1997;
        String cameron = "Cameron";
        String rating = "9";
        Movie titanic = new Movie(name, yearReleased, cameron, rating);

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.library.stringRepresentationOfItems(Movie.class))
                .thenReturn(titanic.stringRepresentation());
        this.listMoviesCommand.execute();

        verify(this.mockIO).println(titanic.stringRepresentation());
    }

}

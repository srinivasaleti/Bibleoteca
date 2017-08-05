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
        library = mock(Library.class);
        mockIO = mock(IO.class);
        listMoviesCommand = new ListMoviesCommand(library, mockIO);
    }

    @Test
    void displayNoMoviesAvailable() {
        when(library.isEmpty(Movie.class)).thenReturn(true);
        listMoviesCommand.execute();
        String noMoviesAvailable = "No Movies Available";

        verify(mockIO).println(noMoviesAvailable);
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

        when(library.isEmpty(Movie.class)).thenReturn(false);
        listMoviesCommand.execute();

        verify(mockIO).println(movies);
        verify(mockIO).println(header);
    }

    @Test
    void displayMoviesInBiblioteca() {
        String name = "Titanic";
        int yearReleased = 1997;
        String cameron = "Cameron";
        String rating = "9";
        Movie titanic = new Movie(name, yearReleased, cameron, rating);

        when(library.isEmpty(Movie.class)).thenReturn(false);
        when(library.stringRepresentationOfItems(Movie.class))
                .thenReturn(titanic.stringRepresentation());
        listMoviesCommand.execute();

        verify(mockIO).println(titanic.stringRepresentation());
    }

}

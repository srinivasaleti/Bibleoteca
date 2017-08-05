package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutMovieCommandTest {

    private IO mockIO;
    private Library library;
    private CheckoutMovieCommand checkoutMovieCommand;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        library = mock(Library.class);
        checkoutMovieCommand = new CheckoutMovieCommand(library, mockIO);
    }

    @Test
    void displayNoMoviesAvailable() {
        String noMoviesAvailable = "No Movies Available";

        when(library.isEmpty(Movie.class)).thenReturn(true);
        checkoutMovieCommand.execute();

        verify(mockIO).println(noMoviesAvailable);
    }

    @Test
    void checkoutAMovie() {
        String movieName = "BookName";

        when(library.isEmpty(Movie.class)).thenReturn(false);
        when(library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        when(mockIO.getInput()).thenReturn(movieName);
        checkoutMovieCommand.execute();

        verify(library).checkoutItem(Movie.class, movieName);
    }

    @Test
    void successFulReturn() {
        String name = "Movie Name";
        int yearReleased = 1000;
        String director = "director";
        String rating = "unrated";
        Movie movie = new Movie(name, yearReleased, director, rating);
        String successMessage = "Thank You Enjoy the Movie";

        when(library.isEmpty(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(name);
        when(library.checkoutItem(Movie.class, name))
                .thenReturn(java.util.Optional.of(movie));
        checkoutMovieCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void dipslayUnSuccessMessage() {
        String movieName = "Movie Name";
        String unSuccessMessage = "That Movie is not available";

        when(library.isEmpty(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(movieName);
        when(library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        checkoutMovieCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

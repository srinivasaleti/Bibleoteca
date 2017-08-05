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
        this.mockIO = mock(IO.class);
        this.library = mock(Library.class);
        this.checkoutMovieCommand = new CheckoutMovieCommand(this.library, mockIO);
    }

    @Test
    void displayNoMoviesAvailable() {
        String noMoviesAvailable = "No Movies Available";

        when(this.library.isEmpty(Movie.class)).thenReturn(true);
        this.checkoutMovieCommand.execute();

        verify(this.mockIO).println(noMoviesAvailable);
    }

    @Test
    void checkoutAMovie() {
        String movieName = "BookName";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(movieName);
        this.checkoutMovieCommand.execute();

        verify(this.library).checkoutItem(Movie.class, movieName);
    }

    @Test
    void displaySuccessMessageAfterSuccessFulReturn() {
        String name = "Movie Name";
        int yearReleased = 1000;
        String director = "director";
        String rating = "unrated";
        Movie movie = new Movie(name, yearReleased, director, rating);
        String successMessage = "Thank You Enjoy the Movie";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.mockIO.getInput()).thenReturn(name);
        when(this.library.checkoutItem(Movie.class, name))
                .thenReturn(java.util.Optional.of(movie));
        this.checkoutMovieCommand.execute();

        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessageForUnSuccessfulCheckout() {
        String movieName = "Movie Name";
        String unSuccessMessage = "That Movie is not available";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.mockIO.getInput()).thenReturn(movieName);
        when(this.library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        this.checkoutMovieCommand.execute();

        verify(this.mockIO).println(unSuccessMessage);
    }

}

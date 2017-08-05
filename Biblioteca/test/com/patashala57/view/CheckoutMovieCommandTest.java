package com.patashala57.view;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
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
    void displayNoMoviesAvailableMessage() {
        String noMoviesAvailable = "No Movies Available";

        when(library.isNoItemsAvailable(Movie.class)).thenReturn(true);
        checkoutMovieCommand.execute();

        verify(mockIO).println(noMoviesAvailable);
    }

    @Test
    void checkOutAMovie() {
        String movieName = "BookName";

        when(library.isNoItemsAvailable(Movie.class)).thenReturn(false);
        when(library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        when(mockIO.getInput()).thenReturn(movieName);
        checkoutMovieCommand.execute();

        verify(library).checkoutItem(Movie.class, movieName);
    }

    @Test
    void successFulReturn() {
        String movieName = "Movie Name";
        Movie movie = new Movie("name", 1000, "director", "unrated");
        String successMessage = "Thank You Enjoy the Movie";

        when(library.isNoItemsAvailable(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(movieName);
        when(library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.of(movie));
        checkoutMovieCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void dipslayUnSuccessMessage() {
        String movieName = "Movie Name";
        String unSuccessMessage = "That Movie is not available";

        when(library.isNoItemsAvailable(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(movieName);
        when(library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        checkoutMovieCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

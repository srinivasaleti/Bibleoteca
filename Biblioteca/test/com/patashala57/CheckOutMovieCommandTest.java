package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutMovieCommandTest {

    private IO mockIO;
    private Biblioteca biblioteca;
    private CheckoutMovieCommand checkoutMovieCommand;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        biblioteca=mock(Biblioteca.class);
        checkoutMovieCommand=new CheckoutMovieCommand(biblioteca,mockIO);
    }

    @Test
    void displayNoMoviesAvailableMessage() {
        String noMoviesAvailable = "No Movies Available";

        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(true);
        checkoutMovieCommand.execute();

        verify(mockIO).println(noMoviesAvailable);
    }

    @Test
    void readInputFromUser() {
        String movieName = "Enter a Movie Name to check Out::";

        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(false);
        checkoutMovieCommand.execute();

        verify(mockIO).print(movieName);
        verify(mockIO).getInput();
    }

    @Test
    void shouldCallCheckOutMethodOfBibiloteca() {
        String movieName = "movieName";

        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(movieName);
        checkoutMovieCommand.execute();

        verify(biblioteca).checkoutItem(Movie.class,movieName);
    }

    @Test
    void displaySuccessMessage(){
        String movieName="Movie Name";
        Movie movie=new Movie("name",1000,"director","unrated");
        String successMessage = "Thank You Enjoy the Movie";

        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(movieName);
        when(biblioteca.checkoutItem(Movie.class,movieName)).thenReturn(movie);
        checkoutMovieCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void dipslayUnSuccessMessage(){
        String movieName="Movie Name";
        String unSuccessMessage = "That Movie is not available";

        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(movieName);
        when(biblioteca.checkoutItem(Movie.class,movieName)).thenReturn(null);
        checkoutMovieCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

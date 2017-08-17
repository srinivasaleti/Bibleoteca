package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.model.User;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutMovieCommandTest {

    private IO mockIO;
    private Library library;
    private CheckoutMovieCommand checkoutMovieCommand;
    private User currentUser;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Library.class);
        this.currentUser=new User("1","1","1","1","1");
        this.checkoutMovieCommand = new CheckoutMovieCommand(this.library, mockIO,this.currentUser);
    }

    @Test
    void cnanotInteractWithLibraryIfNoMoviesAvailable() {
        String movieName = "MovieName";
        when(this.library.isEmpty(Movie.class)).thenReturn(false);

        verify(this.library, never()).checkoutItem(Movie.class, movieName);
    }

    @Test
    void checkoutAMovie() {
        String movieName = "MovieName";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.library.checkoutItem(Movie.class, movieName))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(movieName);
        this.checkoutMovieCommand.execute();

        verify(this.library).checkoutItem(Movie.class, movieName);
    }

}

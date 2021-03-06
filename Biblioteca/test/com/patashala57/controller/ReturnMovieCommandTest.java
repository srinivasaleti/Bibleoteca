package com.patashala57.controller;

import com.patashala57.model.Biblioteca;
import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.model.User;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class ReturnMovieCommandTest {

    private IO mockIO;
    private Library library;
    private ReturnMovieCommand returnMovieCommand;
    private User currentUser;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Biblioteca.class);
        this.currentUser = new User("1", "1", "1", "1", "1");
        this.returnMovieCommand = new ReturnMovieCommand(this.library, this.mockIO, this.currentUser);
    }

    @Test
    void returnMovieToBiblioteca() {
        String itemName = "name";

        when(this.mockIO.getInput()).thenReturn(itemName);
        when(this.library.whoCheckedOut(itemName, Movie.class)).thenReturn(Optional.of(this.currentUser));
        this.returnMovieCommand.execute();

        verify(this.library).returnItem(Movie.class, itemName, this.currentUser);
    }

}

package com.patashala57.controller;

import com.patashala57.model.Biblioteca;
import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ReturnMovieCommandTest {

    private IO mockIO;
    private Library library;
    private ReturnMovieCommand returnMovieCommand;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Biblioteca.class);
        this.returnMovieCommand = new ReturnMovieCommand(this.library, this.mockIO);
    }

    @Test
    void readInputFromUserToReturnMovie() {
        String enterMovieName = "Enter Movie Name to return::";
        this.returnMovieCommand.execute();

        verify(this.mockIO).print(enterMovieName);
        verify(this.mockIO).getInput();
    }

    @Test
    void returnMovieToBiblioteca() {
        when(this.mockIO.getInput()).thenReturn("Movie");
        this.returnMovieCommand.execute();

        verify(this.library).returnItem(Movie.class, "Movie");
    }

    @Test
    void displaySuccessMessage() {
        String successMessage = "Thank you for returning the Movie";
        String movieName = "Harry Poter";

        when(this.mockIO.getInput()).thenReturn(movieName);
        when(this.library.returnItem(Movie.class, movieName)).thenReturn(true);
        this.returnMovieCommand.execute();

        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessage() {
        String unSuccessMessage = "That is not a valid Movie to return";
        String movieName = "Harry Poter";

        when(this.mockIO.getInput()).thenReturn(movieName);
        when(this.library.returnItem(Movie.class, movieName)).thenReturn(false);
        this.returnMovieCommand.execute();

        verify(this.mockIO).println(unSuccessMessage);
    }

}

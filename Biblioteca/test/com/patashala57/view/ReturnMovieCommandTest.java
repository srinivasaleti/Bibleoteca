package com.patashala57.view;

import com.patashala57.model.Biblioteca;
import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ReturnMovieCommandTest {

    private IO mockIO;
    private Library library;
    private ReturnMovieCommand returnMovieCommand;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        library = mock(Biblioteca.class);
        returnMovieCommand = new ReturnMovieCommand(library, mockIO);
    }

    @Test
    void readInputFromUserToReturnMovie() {
        String enterMovieName = "Enter Movie Name to return::";
        returnMovieCommand.execute();

        verify(mockIO).print(enterMovieName);
        verify(mockIO).getInput();
    }

    @Test
    void returnMovieToBiblioteca() {
        when(mockIO.getInput()).thenReturn("Movie");
        returnMovieCommand.execute();

        verify(library).returnItem(Movie.class, "Movie");
    }

    @Test
    void displaySuccessMessage() {
        String successMessage = "Thank you for returning the Movie";

        String movieName = "Harry Poter";
        when(mockIO.getInput()).thenReturn(movieName);
        when(library.returnItem(Movie.class, movieName)).thenReturn(true);
        returnMovieCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessage() {
        String unSuccessMessage = "That is not a valid Movie to return";

        String movieName = "Harry Poter";
        when(mockIO.getInput()).thenReturn(movieName);
        when(library.returnItem(Movie.class, movieName)).thenReturn(false);
        returnMovieCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListMoviesCommandTest {
    private IO mockIO;
    private Biblioteca biblioteca;
    private ListMoviesCommand listMoviesCommand;

    @BeforeEach
    void beforeEach() {
        biblioteca = mock(Biblioteca.class);
        mockIO = mock(IO.class);
        listMoviesCommand = new ListMoviesCommand(biblioteca,mockIO);

    }

    @Test
    void displayNoMoviesAvailable() {
        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(true);
        listMoviesCommand.execute();
        String noMoviesAvailable = "No Movies Available";

        verify(mockIO).println(noMoviesAvailable);
    }

    @Test
    void displayHeading(){
        String movies = "Movies::";
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);

        when(biblioteca.isNoItemsAvailable(Movie.class)).thenReturn(false);
        listMoviesCommand.execute();

        verify(mockIO).println(movies);
        verify(mockIO).println(header);
    }

    @Test
    void shouldCallDisplayAllItemsBibiloteca() {
        listMoviesCommand.execute();

        verify(biblioteca).displayItems(Movie.class);
    }

}

package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListItemsTest {

    private IO mockIO;
    private ListItems listItems;
    private Library library;

    @BeforeEach
    void beforeEach() {
        library = mock(Library.class);
        mockIO = mock(IO.class);
        listItems = new ListItems(library, mockIO);
    }

    @Test
    void displayNoBooks() {
        String noBooksAvailable = "No Books Available";

        when(this.library.isEmpty(Book.class)).thenReturn(true);
        this.listItems.listAll(Book.class);

        verify(this.mockIO).println(noBooksAvailable);
    }

    @Test
    void displayNoMovies() {
        String noMoviesAvailable = "No Movies Available";

        when(this.library.isEmpty(Movie.class)).thenReturn(true);
        this.listItems.listAll(Movie.class);

        verify(this.mockIO).println(noMoviesAvailable);
    }


    @Test
    void displayListBooksHeader() {
        String type = "Books::";
        String format = "%-35s %-35s %-35s";
        String name = "Name";
        String author = "Author";
        String yearPublished = "Year Published";
        String header = String.format(format, name, author, yearPublished);

        this.listItems.listAll(Book.class);

        verify(this.mockIO).println(type);
        verify(this.mockIO).println(header);
    }

    @Test
    void displayListMoviesHeader() {
        String type = "Movies::";
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        this.listItems.listAll(Movie.class);

        verify(this.mockIO).println(type);
        verify(this.mockIO).println(header);
    }

    @Test
    void displayAllBooksInLibrary(){
        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        this.listItems.listAll(Book.class);

        verify(this.library).stringRepresentationOfItems(Book.class);
    }

    @Test
    void displayAllMoviesInLibrary(){
        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        this.listItems.listAll(Movie.class);

        verify(this.library).stringRepresentationOfItems(Movie.class);
    }

}
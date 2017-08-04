package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    private Biblioteca biblioteca;
    private Book loveStory = new Book("Love Story", "Erich Segal", 1970);
    private Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
    private Movie twilight = new Movie("Twilight", 2009, "HardWicke", "8");
    private Movie titanic = new Movie("Titanic", 1997, "Cameron", "9");
    private String lineSepartor = System.lineSeparator();

    @Test
    void expectedEmptyString() {
        biblioteca = new Biblioteca(null);
        String empty = "";

        assertEquals(empty, biblioteca.stringRepresentationOfItems(Book.class));
    }

    @Test
    void expectedAllBooks() {
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
        String result = loveStory.stringRepresentation() + lineSepartor +
                firstLove.stringRepresentation() + lineSepartor;

        assertEquals(result, biblioteca.stringRepresentationOfItems(Book.class));
    }

    @Test
    void expectedAllMovies() {
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
        String result = twilight.stringRepresentation() + lineSepartor +
                titanic.stringRepresentation() + lineSepartor;

        assertEquals(result, biblioteca.stringRepresentationOfItems(Movie.class));
    }

    @Test
    void checkoutABook() {
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));

        assertEquals(loveStory, biblioteca.checkoutItem(Book.class, "Love Story"));
    }

    @Test
    void checkoutAMovie() {
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));

        assertEquals(titanic, biblioteca.checkoutItem(Movie.class, "titanic"));
    }

    @Test
    void cannotReturnAUncheckedOutBook(){
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));

        assertEquals(false, biblioteca.returnItem(Book.class, "love Story"));
    }

    @Test
    void cannotReturnAUncheckedOutMovie(){
        biblioteca=new Biblioteca(Arrays.asList(loveStory,firstLove,twilight,titanic));

        assertEquals(false,biblioteca.returnItem(Movie.class,"loveStory"));
    }

    @Test
    void returnABookToBiblioteca() {
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
        biblioteca.checkoutItem(Book.class, "first love");

        assertEquals(true, biblioteca.returnItem(Book.class, "first love"));
    }

    @Test
    void returnAMovieToBiblioteca(){
        biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
        biblioteca.checkoutItem(Movie.class, "titanic");

        assertEquals(true, biblioteca.returnItem(Movie.class, "titanic"));
    }

    @Test
    void noBooksAvailbleInBiblioteca(){
        biblioteca = new Biblioteca(null);

        assertEquals(true,biblioteca.isNoItemsAvailable(Book.class));
    }

    @Test
    void noMoviesAvailableInBiblioteca(){
        biblioteca=new Biblioteca(null);

        assertEquals(true,biblioteca.isNoItemsAvailable(Movie.class));
    }

    @Test
    void booksAreAvailableInBibioteca(){
        biblioteca=new Biblioteca(Arrays.asList(firstLove,titanic));

        assertEquals(false,biblioteca.isNoItemsAvailable(Book.class));
    }

    @Test
    void moviesAreAvailableInBibioteca(){
        biblioteca=new Biblioteca(Arrays.asList(firstLove,titanic));

        assertEquals(false,biblioteca.isNoItemsAvailable(Book.class));
    }

}

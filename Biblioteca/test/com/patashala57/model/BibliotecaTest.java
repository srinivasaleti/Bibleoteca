package com.patashala57.model;

import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaTest {

    private Biblioteca biblioteca;
    private Book loveStory = new Book("Love Story", "Erich Segal", 1970);
    private Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
    private Movie twilight = new Movie("Twilight", 2009, "HardWicke", "8");
    private Movie titanic = new Movie("Titanic", 1997, "Cameron", "9");
    private String lineSeparator;

    @BeforeEach
    void beforeEach() {
        lineSeparator = IO.LINE_SEPARATOR;
    }

    @Nested
    class ListItems {
        @Test
        void noBooksInBiblioteca() {
            biblioteca = new Biblioteca(null);
            String empty = "";

            assertEquals(empty, biblioteca.stringRepresentationOfItems(Book.class));
        }

        @Test
        void noMoviesInBiblioteca() {
            biblioteca = new Biblioteca(null);
            String empty = "";

            assertEquals(empty, biblioteca.stringRepresentationOfItems(Movie.class));
        }

        @Test
        void allBooksInBiblioteca() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String result = loveStory.stringRepresentation() + lineSeparator +
                    firstLove.stringRepresentation() + lineSeparator;

            assertEquals(result, biblioteca.stringRepresentationOfItems(Book.class));
        }

        @Test
        void allMoviesInBiblioteca() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String result = twilight.stringRepresentation() + lineSeparator +
                    titanic.stringRepresentation() + lineSeparator;

            assertEquals(result, biblioteca.stringRepresentationOfItems(Movie.class));
        }

    }

    @Nested
    class CheckoutItems {

        @Test
        void checkoutABookFromBiblioteca() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutBook = "Love Story";

            assertEquals(loveStory, biblioteca.checkoutItem(Book.class, checkoutBook).get());
        }

        @Test
        void checkoutAMovieFromBiblioteca() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutMovie = "titanic";

            assertEquals(titanic, biblioteca.checkoutItem(Movie.class, checkoutMovie).get());
        }

    }

    @Nested
    class ReturnItems {

        @Test
        void cannotReturnAUncheckedOutBook() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutBook = "first Love";
            String returnBook = "love Story";

            biblioteca.checkoutItem(Book.class, checkoutBook);

            assertEquals(false, biblioteca.returnItem(Book.class, returnBook));
        }

        @Test
        void cannotReturnAUncheckedOutMovie() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutMovie = "twilight";
            String returnMovie = "titanic";

            biblioteca.checkoutItem(Movie.class, checkoutMovie);

            assertEquals(false, biblioteca.returnItem(Movie.class, returnMovie));
        }

        @Test
        void returnCheckedOutBookToBiblioteca() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String bookName = "first love";

            biblioteca.checkoutItem(Book.class, bookName);

            assertEquals(true, biblioteca.returnItem(Book.class, bookName));
        }

        @Test
        void returnCheckedOutMovieToBiblioteca() {
            biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String movieName = "titanic";

            biblioteca.checkoutItem(Movie.class, movieName);

            assertEquals(true, biblioteca.returnItem(Movie.class, movieName));
        }

    }

    @Test
    void noBooksAvailableInBiblioteca() {
        biblioteca = new Biblioteca(null);

        assertEquals(true, biblioteca.isEmpty(Book.class));
    }

    @Test
    void noMoviesAvailableInBiblioteca() {
        biblioteca = new Biblioteca(null);

        assertEquals(true, biblioteca.isEmpty(Movie.class));
    }

    @Test
    void booksAreAvailableInBiblioteca() {
        biblioteca = new Biblioteca(Arrays.asList(firstLove, titanic));

        assertEquals(false, biblioteca.isEmpty(Book.class));
    }

    @Test
    void moviesAreAvailableInBiblioteca() {
        biblioteca = new Biblioteca(Arrays.asList(firstLove, titanic));

        assertEquals(false, biblioteca.isEmpty(Movie.class));
    }

}

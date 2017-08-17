package com.patashala57.model;

import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BibliotecaTest {

    private Biblioteca biblioteca;
    private Book loveStory = new Book("Love Story", "Erich Segal", 1970);
    private Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
    private Movie twilight = new Movie("Twilight", 2009, "HardWicke", "8");
    private Movie titanic = new Movie("Titanic", 1997, "Cameron", "9");
    private String lineSeparator;
    private User user;
    @BeforeEach
    void beforeEach() {
        user = new User("1", "1", "1", "1", "1");
        this.lineSeparator = IO.LINE_SEPARATOR;
    }

    @Nested
    class ListItems {

        private Biblioteca biblioteca;

        @Test
        void noBooksInBiblioteca() {
            this.biblioteca = new Biblioteca(null);
            String empty = "";

            assertEquals(empty, this.biblioteca.stringRepresentationOfItems(Book.class));
        }

        @Test
        void noMoviesInBiblioteca() {
            this.biblioteca = new Biblioteca(null);
            String empty = "";

            assertEquals(empty, this.biblioteca.stringRepresentationOfItems(Movie.class));
        }

        @Test
        void allBooksInBiblioteca() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String result = loveStory.stringRepresentation() + lineSeparator +
                    firstLove.stringRepresentation() + lineSeparator;

            assertEquals(result, this.biblioteca.stringRepresentationOfItems(Book.class));
        }

        @Test
        void allMoviesInBiblioteca() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String result = twilight.stringRepresentation() + lineSeparator +
                    titanic.stringRepresentation() + lineSeparator;

            assertEquals(result, this.biblioteca.stringRepresentationOfItems(Movie.class));
        }

    }

    @Nested
    class CheckoutItems {

        private Biblioteca biblioteca;
        private User user = new User("1", "1", "1", "1", "1");

        @Test
        void checkoutABookFromBiblioteca() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutBook = "Love Story";

            assertEquals(Optional.of(loveStory), this.biblioteca.checkoutItem(Book.class, checkoutBook, this.user));
        }

        @Test
        void checkoutAMovieFromBiblioteca() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutMovie = "titanic";

            assertEquals(Optional.of(titanic), this.biblioteca.checkoutItem(Movie.class, checkoutMovie, null));
        }

    }

    @Nested
    class ReturnItems {

        private Biblioteca biblioteca;
        private User user = new User("1", "1", "1", "1", "1");

        @Test
        void cannotReturnAUncheckedOutBook() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutBook = "first Love";
            String returnBook = "love Story";

            this.biblioteca.checkoutItem(Book.class, checkoutBook, this.user);

            assertEquals(false, this.biblioteca.returnItem(Book.class, returnBook, user));
        }

        @Test
        void cannotReturnAUncheckedOutMovie() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String checkoutMovie = "twilight";
            String returnMovie = "titanic";

            this.biblioteca.checkoutItem(Movie.class, checkoutMovie, this.user);

            assertEquals(false, this.biblioteca.returnItem(Movie.class, returnMovie, this.user));
        }

        @Test
        void returnCheckedOutBookToBiblioteca() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String bookName = "first love";

            this.biblioteca.checkoutItem(Book.class, bookName, this.user);

            assertEquals(true, this.biblioteca.returnItem(Book.class, bookName, this.user));
        }

        @Test
        void returnCheckedOutMovieToBiblioteca() {
            this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
            String movieName = "titanic";

            this.biblioteca.checkoutItem(Movie.class, movieName, this.user);

            assertEquals(true, this.biblioteca.returnItem(Movie.class, movieName, user));
        }

    }

    @Test
    void noBooksAvailableInBiblioteca() {
        this.biblioteca = new Biblioteca(null);

        assertEquals(true, this.biblioteca.isEmpty(Book.class));
    }

    @Test
    void noMoviesAvailableInBiblioteca() {
        this.biblioteca = new Biblioteca(null);

        assertEquals(true, this.biblioteca.isEmpty(Movie.class));
    }

    @Test
    void booksAreAvailableInBiblioteca() {
        this.biblioteca = new Biblioteca(Arrays.asList(firstLove, titanic));

        assertEquals(false, this.biblioteca.isEmpty(Book.class));
    }

    @Test
    void moviesAreAvailableInBiblioteca() {
        this.biblioteca = new Biblioteca(Arrays.asList(firstLove, titanic));

        assertEquals(false, this.biblioteca.isEmpty(Movie.class));
    }

    @Test
    void validUser() {
        User user1 = new User("srinu", "123", "1234", "s@gmaill.com", "124");

        this.biblioteca = new Biblioteca(Arrays.asList(firstLove, titanic), Collections.singletonList(user1));

        assertEquals(Optional.of(user1), this.biblioteca.isValidUserCredentials("123", "1234"));
    }

    @Test
    void inValidUser() {
        User user1 = new User("srinu", "123", "1234", "s@gmaill.com", "124");

        this.biblioteca = new Biblioteca(Arrays.asList(firstLove, titanic), Collections.singletonList(user1));

        assertNotEquals(Optional.of(user1), this.biblioteca.isValidUserCredentials("123", "123"));
    }

    @Test
    void expectedUserWhoCheckedOutTheBook(){
        this.biblioteca = new Biblioteca(Arrays.asList(loveStory, firstLove, twilight, titanic));
        String bookName = "first love";

        this.biblioteca.checkoutItem(Book.class, bookName, user);
        this.biblioteca.addDetailsToCheckOutRegister(firstLove,user);

        assertEquals(Optional.of(user), this.biblioteca.whoCheckedOut(bookName, Book.class));
    }

}

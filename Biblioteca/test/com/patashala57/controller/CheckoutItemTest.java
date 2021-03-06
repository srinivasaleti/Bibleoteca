package com.patashala57.controller;

import com.patashala57.model.*;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutItemTest {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String ENTER_BOOK_NAME_TO_CHECK_OUT = "Enter a Book Name to check Out::";
    private static final String CHECKOUT_BOOK_SUCCESS_MESSAGE = "Thank you! Enjoy the book";
    private static final String CHECKOUT_BOOK_UNSUCCESS_MESSAGE = "That book is not available";

    private static final String NO_MOVIE_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String ENTER_MOVIE_NAME_TO_CHECK_OUT = "Enter a Movie Name to check Out::";
    private static final String CHECKOUT_MOVIE_SUCCESS_MESSAGE = "Thank You Enjoy the Movie";
    private static final String CHECKOUT_MOVIE_UNSUCCESS_MESSAGE = "That Movie is not available";

    private IO mockIO;
    private CheckoutItem checkoutItems;
    private Library library;
    private User user;

    @BeforeEach
    void beforeEach() {
        library = mock(Library.class);
        mockIO = mock(IO.class);
        this.user =new User("1","1","1","1","1");
        checkoutItems = new CheckoutBookCommand(library, mockIO,this.user);
    }

    @Test
    void displayNoBooksAvailable() {
        String noBooksAvailable = "No Books Available";

        when(library.isEmpty(Book.class)).thenReturn(true);
        this.checkoutItems.checkOut(Book.class, NO_BOOK_AVAILABLE_MESSAGE, ENTER_BOOK_NAME_TO_CHECK_OUT,
                CHECKOUT_BOOK_SUCCESS_MESSAGE, CHECKOUT_BOOK_UNSUCCESS_MESSAGE);

        verify(this.mockIO).println(noBooksAvailable);
    }

    @Test
    void displayNoMoviesAvailable() {
        String noMoviesAvailable = "No Movies Available";

        when(this.library.isEmpty(Movie.class)).thenReturn(true);
        this.checkoutItems.checkOut(Movie.class, NO_MOVIE_AVAILABLE_MESSAGE, ENTER_MOVIE_NAME_TO_CHECK_OUT,
                CHECKOUT_MOVIE_SUCCESS_MESSAGE, CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);

        verify(this.mockIO).println(noMoviesAvailable);
    }

    @Test
    void checkoutABook() {
        String bookNameToCheckout = "BookName";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookNameToCheckout,this.user))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(bookNameToCheckout);
        this.checkoutItems.checkOut(Book.class, NO_BOOK_AVAILABLE_MESSAGE, ENTER_BOOK_NAME_TO_CHECK_OUT,
                CHECKOUT_BOOK_SUCCESS_MESSAGE, CHECKOUT_BOOK_UNSUCCESS_MESSAGE);

        verify(this.library).checkoutItem(Book.class, bookNameToCheckout,this.user);
    }

    @Test
    void checkoutAMovie() {
        String movieName = "MovieName";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.library.checkoutItem(Movie.class, movieName,this.user))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(movieName);
        this.checkoutItems.checkOut(Movie.class, NO_MOVIE_AVAILABLE_MESSAGE, ENTER_MOVIE_NAME_TO_CHECK_OUT,
                CHECKOUT_MOVIE_SUCCESS_MESSAGE, CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);

        verify(this.library).checkoutItem(Movie.class, movieName,this.user);
    }

    @Test
    void displaySuccessMessageAfterSuccessfulCheckoutBook() {
        String bookNameToCheckOut = "BookName";
        Book book = new Book("name", "author", 1999);
        String successMessage = "Thank you! Enjoy the book";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookNameToCheckOut,this.user))
                .thenReturn(java.util.Optional.of(book));
        when(this.mockIO.getInput()).thenReturn(bookNameToCheckOut);
        this.checkoutItems.checkOut(Book.class, NO_BOOK_AVAILABLE_MESSAGE, ENTER_BOOK_NAME_TO_CHECK_OUT,
                CHECKOUT_BOOK_SUCCESS_MESSAGE, CHECKOUT_BOOK_UNSUCCESS_MESSAGE);


        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessageForunSuccessfulCheckoutBook() {
        String bookName = "BookName";
        String unSuccessMessage = "That book is not available";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookName,this.user))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(bookName);
        this.checkoutItems.checkOut(Book.class, NO_BOOK_AVAILABLE_MESSAGE, ENTER_BOOK_NAME_TO_CHECK_OUT,
                CHECKOUT_BOOK_SUCCESS_MESSAGE, CHECKOUT_BOOK_UNSUCCESS_MESSAGE);

        verify(this.mockIO).println(unSuccessMessage);
    }


    @Test
    void displaySuccessMessageAfterSuccessFulCheckoutMovie() {
        String name = "Movie Name";
        int yearReleased = 1000;
        String director = "director";
        String rating = "unrated";
        Movie movie = new Movie(name, yearReleased, director, rating);
        String successMessage = "Thank You Enjoy the Movie";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.mockIO.getInput()).thenReturn(name);
        when(this.library.checkoutItem(Movie.class, name,this.user))
                .thenReturn(java.util.Optional.of(movie));
        this.checkoutItems.checkOut(Movie.class, NO_MOVIE_AVAILABLE_MESSAGE, ENTER_MOVIE_NAME_TO_CHECK_OUT,
                CHECKOUT_MOVIE_SUCCESS_MESSAGE, CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);


        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessageForUnSuccessfulCheckoutMove() {
        String movieName = "Movie Name";
        String unSuccessMessage = "That Movie is not available";

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.mockIO.getInput()).thenReturn(movieName);
        when(this.library.checkoutItem(Movie.class, movieName,this.user))
                .thenReturn(java.util.Optional.empty());
        this.checkoutItems.checkOut(Movie.class, NO_MOVIE_AVAILABLE_MESSAGE, ENTER_MOVIE_NAME_TO_CHECK_OUT,
                CHECKOUT_MOVIE_SUCCESS_MESSAGE, CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);

        verify(this.mockIO).println(unSuccessMessage);
    }

    @Test
    void afterSuccessFulCheckoutDetailsShouldAddToCheckoutRegister(){
        String name = "Movie Name";
        int yearReleased = 1000;
        String director = "director";
        String rating = "unrated";
        Movie movie = new Movie(name, yearReleased, director, rating);

        when(this.library.isEmpty(Movie.class)).thenReturn(false);
        when(this.mockIO.getInput()).thenReturn(name);
        when(this.library.checkoutItem(Movie.class, name,this.user))
                .thenReturn(java.util.Optional.of(movie));
        this.checkoutItems.checkOut(Movie.class, NO_MOVIE_AVAILABLE_MESSAGE, ENTER_MOVIE_NAME_TO_CHECK_OUT,
                CHECKOUT_MOVIE_SUCCESS_MESSAGE, CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);

        verify(this.library).addDetailsToCheckOutRegister(movie,this.user);
    }

}
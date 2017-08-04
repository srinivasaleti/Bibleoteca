package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaTest {

    private IO mockIO;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
    }

    @Test
    void displaySingleBook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<LibraryItem> books = Collections.singletonList(halfGirlFriend);
        Biblioteca biblioteca = new Biblioteca(mockIO, books);

        biblioteca.displayItems(Book.class);

        verify(mockIO).println(halfGirlFriend.stringRepresentation());
    }

    @Test
    void displayListOfBooks() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<LibraryItem> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
        aBiblioteca.displayItems(Movie.class);

        verify(mockIO).println(halfGirlFriend.stringRepresentation());
        verify(mockIO).println(loveStory.stringRepresentation());
        verify(mockIO).println(firstLove.stringRepresentation());
    }


    @Nested
    class CheckOutBook {

        @Test
        void successFullCheckout() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            List<LibraryItem> books = Collections.singletonList(halfGirlFriend);
            Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
            String checkOutBooks = "2";
            String halfGirlFriendBookName = "half girlFriend";
            String quit = "quit";
            String selectOptionMenu = "Select an Option From Menu::";
            String enterBookNameToCheckOut = "Enter a Book Name to check Out::";
            String thankYouEnjoyBook = "Thank you! Enjoy the book";
            int wantedNumberOfInvocations = 2;

            when(mockIO.getInput()).
                    thenReturn(checkOutBooks).
                    thenReturn(halfGirlFriendBookName).
                    thenReturn(quit);
            //aBiblioteca.launch();

            verify(mockIO, times(wantedNumberOfInvocations)).print(selectOptionMenu);
            verify(mockIO).print(enterBookNameToCheckOut);
            verify(mockIO).println(thankYouEnjoyBook);
        }

        @Test
        void removeBookFromaBibliotecaAfterCheckOut() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            Book loveStory = new Book("Love Story", "Erich Segal", 1970);
            List<LibraryItem> books = Arrays.asList(halfGirlFriend, loveStory);
            Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
            String format = "%-35s %-35s %-35s";
            String header = String.format(format, "Name", "Author", "Year");
            String checkOutBooks = "2";
            String loveStoryBookName = "Love Story";
            String listBooks = "1";
            String quit = "quit";
            String enterBookName = "Enter a Book Name to check Out::";
            String booksString = "Books::";
            String selectOptionFromMenu = "Select an Option From Menu::";
            int wantedNumberOfInvocations = 3;

            when(mockIO.getInput()).
                    thenReturn(checkOutBooks).
                    thenReturn(loveStoryBookName).
                    thenReturn(listBooks).
                    thenReturn(quit);
            //aBiblioteca.launch();

            verify(mockIO, times(wantedNumberOfInvocations)).print(selectOptionFromMenu);
            verify(mockIO).print(enterBookName);
            verify(mockIO).println(booksString);
            verify(mockIO).println(header);
            verify(mockIO).println(halfGirlFriend.stringRepresentation());
        }

        @Test
        void displayBookNotAvailableAfterUnSuccessfulCheckOutABook() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            List<LibraryItem> books = Collections.singletonList(halfGirlFriend);
            Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
            String checkOutBooks = "2";
            String girlFriendBookName = "girlFriend";
            String quit = "quit";
            String selectOption = "Select an Option From Menu::";
            String enterBookToCheckout = "Enter a Book Name to check Out::";
            String bookNotAvailable = "That book is not available";
            int wantedNumberOfInvocations = 2;

            when(mockIO.getInput()).
                    thenReturn(checkOutBooks).
                    thenReturn(girlFriendBookName).
                    thenReturn(quit);
            //aBiblioteca.launch();

            verify(mockIO, times(wantedNumberOfInvocations)).print(selectOption);
            verify(mockIO).print(enterBookToCheckout);
            verify(mockIO).println(bookNotAvailable);
        }

    }

    @Test
    void displayMoviesInLibraryItems() {
        Movie aMovie = new Movie("Twilight", 2009, "HardWicke", "8");
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<LibraryItem> movie = Arrays.asList(aMovie,halfGirlFriend);
        Biblioteca biblioteca = new Biblioteca(mockIO, movie);

        biblioteca.displayItems(Book.class);

        verify(mockIO).println(aMovie.stringRepresentation());
        verify(mockIO,times(0)).println(halfGirlFriend.stringRepresentation());
    }

}

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
    void displayWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca(mockIO, null);
        String quit = "quit";
        String welcomeMessage = "Welcome To Bangalore Public Library";

        when(mockIO.getInput()).thenReturn(quit);
        biblioteca.launch();

        verify(mockIO).println(welcomeMessage);
    }

    @Test
    void displayNoBooksAvailableWhenThereAreNoBooks() {
        List<LibraryItem> books = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(mockIO, books);
        String listBooks = "1";
        String quit = "quit";
        String noBooksAvailale = "No Books Available";

        when(mockIO.getInput())
                .thenReturn(listBooks)
                .thenReturn(quit);
        biblioteca.launch();

        verify(mockIO).println(noBooksAvailale);
    }

    @Test
    void displaySingleBook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<LibraryItem> books = Collections.singletonList(halfGirlFriend);
        Biblioteca biblioteca = new Biblioteca(mockIO, books);
        String format = "%-35s %-35s %-35s";
        String headding = String.format(format, "Name", "Author", "Year");
        String listBooks = "1";
        String quit = "quit";
        String booksMessage = "Books::";

        when(mockIO.getInput())
                .thenReturn(listBooks)
                .thenReturn(quit);
        biblioteca.launch();

        verify(mockIO).println(booksMessage);
        verify(mockIO).println(headding);
        verify(mockIO).println(halfGirlFriend.stringRepresentation());
    }

    @Test
    void displayMenu() {
        Biblioteca aBiblioteca = new Biblioteca(mockIO, null);
        int wantedNumberOfInvocations = 2;

        aBiblioteca.displayMenu();

        verify(mockIO, times(wantedNumberOfInvocations)).println("");
        verify(mockIO).println("Menu::");
        verify(mockIO).println("1->List Books");
        verify(mockIO).println("2->CheckOut a Book");
        verify(mockIO).println("3->Return a Book");
        verify(mockIO).println("quit to EXIT");
    }

    @Test
    void displayListOfBooks() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<LibraryItem> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
        String format = "%-35s %-35s %-35s";
        String headding = String.format(format, "Name", "Author", "Year");
        String listBooks = "1";
        String quit = "quit";
        String BooksMessage = "Books::";
        String selectOption = "Select an Option From Menu::";
        int wantedNumberOfInvocations = 2;

        when(mockIO.getInput())
                .thenReturn(listBooks)
                .thenReturn(quit);
        aBiblioteca.launch();

        verify(mockIO, times(wantedNumberOfInvocations)).print(selectOption);
        verify(mockIO).println(BooksMessage);
        verify(mockIO).println(headding);
        verify(mockIO).println(halfGirlFriend.stringRepresentation());
        verify(mockIO).println(loveStory.stringRepresentation());
        verify(mockIO).println(firstLove.stringRepresentation());
    }

    @Test
    void displayInvalidOption() {
        Biblioteca aBiblioteca = new Biblioteca(mockIO, new ArrayList<>());
        String expectedMessage = "Invalid Option";
        String invalidOption = "5";
        String selelctAnOptionFromMenu = "Select an Option From Menu::";
        int wantedNumberOfInvocations = 2;
        String QUIT = "quit";

        when(mockIO.getInput()).thenReturn(invalidOption).thenReturn(QUIT);
        aBiblioteca.launch();

        verify(mockIO, times(wantedNumberOfInvocations)).print(selelctAnOptionFromMenu);
        verify(mockIO).println(expectedMessage);
    }

    @Test
    void executeUntilQuit() {
        Biblioteca biblioteca = new Biblioteca(mockIO, new ArrayList<>());
        String quit = "quit";
        String selectAnOption = "Select an Option From Menu::";
        int wantedNumberOfInvocations = 1;

        when(mockIO.getInput()).thenReturn(quit);
        biblioteca.launch();

        verify(mockIO, times(wantedNumberOfInvocations)).print(selectAnOption);
    }

    @Nested
    class CheckOut {

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
            aBiblioteca.launch();

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
            String headding = String.format(format, "Name", "Author", "Year");
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
            aBiblioteca.launch();

            verify(mockIO, times(wantedNumberOfInvocations)).print(selectOptionFromMenu);
            verify(mockIO).print(enterBookName);
            verify(mockIO).println(booksString);
            verify(mockIO).println(headding);
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
            aBiblioteca.launch();

            verify(mockIO, times(wantedNumberOfInvocations)).print(selectOption);
            verify(mockIO).print(enterBookToCheckout);
            verify(mockIO).println(bookNotAvailable);
        }

    }

    @Nested
    class ReturnBook {

        @Test
        void successFullReturnBook() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            Book loveStory = new Book("Love Story", "Erich Segal", 1970);
            List<LibraryItem> books = Arrays.asList(halfGirlFriend, loveStory);
            Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
            String format = "%-35s %-35s %-35s";
            String headding = String.format(format, "Name", "Author", "Year");
            String returnBook = "3";
            String halfGirlFriendBookName = "half girlFriend";
            String quit = "quit";
            String listBooks = "1";
            String checkOut = "2";

            when(mockIO.getInput())
                    .thenReturn(checkOut)
                    .thenReturn(halfGirlFriendBookName)
                    .thenReturn(returnBook)
                    .thenReturn(halfGirlFriendBookName)
                    .thenReturn(listBooks)
                    .thenReturn(quit);
            aBiblioteca.launch();

            verify(mockIO).println(headding);
            verify(mockIO).println(loveStory.stringRepresentation());
            verify(mockIO).println(halfGirlFriend.stringRepresentation());
        }

        @Test
        void displaySuccessfulReturnMessage() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            List<LibraryItem> books = Collections.singletonList(halfGirlFriend);
            Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
            String returnBook = "3";
            String halfGirlFriendBookName = "half girlFriend";
            String quit = "quit";
            String listBooks = "1";
            String greetingMessage = "Thank you for returning the book";
            String checkOut = "2";

            when(mockIO.getInput())
                    .thenReturn(checkOut)
                    .thenReturn(halfGirlFriendBookName)
                    .thenReturn(returnBook)
                    .thenReturn(halfGirlFriendBookName)
                    .thenReturn(listBooks)
                    .thenReturn(quit);
            aBiblioteca.launch();

            verify(mockIO).println(greetingMessage);
        }

        @Test
        void displayUnSuccessFullReturnMessage() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            List<LibraryItem> books = Collections.singletonList(halfGirlFriend);
            Biblioteca aBiblioteca = new Biblioteca(mockIO, books);
            String halfGirlFriendBookName = "half girlFriend";
            String returnBook = "3";
            String quit = "quit";
            String notValidBook = "That is not a valid book to return";

            when(mockIO.getInput()).
                    thenReturn(returnBook)
                    .thenReturn(halfGirlFriendBookName)
                    .thenReturn(quit);
            aBiblioteca.launch();

            verify(mockIO).println(notValidBook);
        }

    }

    @Test
    void displayNoMovies(){
        List<LibraryItem> Movies = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(mockIO, Movies);
        String listMovies = "4";
        String quit = "quit";
        String noBooksAvailale = "No Books Available";

        when(mockIO.getInput())
                .thenReturn(listMovies)
                .thenReturn(quit);
        biblioteca.launch();

        verify(mockIO).println(noBooksAvailale);
    }

    @Test
    void displayASingleMovie() {
        Movie aMovie = new Movie("Twilight", 2009, "HardWicke", "8");
        List<LibraryItem> movie = Collections.singletonList(aMovie);
        Biblioteca biblioteca = new Biblioteca(mockIO, movie);
        String listBooks = "1";
        String quit = "quit";

        when(mockIO.getInput())
                .thenReturn(listBooks)
                .thenReturn(quit);
        biblioteca.launch();

        verify(mockIO).println(aMovie.stringRepresentation());
    }

}

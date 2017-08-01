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

    private IO mockIO;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
    }

    @Test
    void displayWelcomeMessage() {
        Biblioteca aBiblioteca = new Biblioteca(mockIO);

        aBiblioteca.printWelcomeMessage();

        verify(mockIO).println("Welcome To Bangalore Public Library");
    }

    @Test
    void displayNoBooksAvailableWhenThereAreNoBooks() {
        List<Book> books = new ArrayList<>();
        Biblioteca library = new Biblioteca(mockIO, books);

        when(mockIO.getInput()).thenReturn("1").thenReturn("quit");
        library.selectMenu();

        verify(mockIO).println("No Books Available\n");
    }

    @Test
    void displaySingleBook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<Book> books = Collections.singletonList(halfGirlFriend);
        Biblioteca library = new Biblioteca(mockIO, books);
        String format = "%-35s %-35s %-35s";
        String headding = String.format(format, "Name", "Author", "Year");

        when(mockIO.getInput()).thenReturn("1").thenReturn("quit");
        library.selectMenu();

        verify(mockIO).println("Books::");
        verify(mockIO).println(headding);
        verify(mockIO).println(halfGirlFriend.stringRepresentation());
    }

    @Test
    void displayMenu() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);

        library.menu();

        verify(mockIO).println("Menu::");
        verify(mockIO).println("1->List Books");
        verify(mockIO).println("2->CheckOut a Book");
        verify(mockIO).println("quit to EXIT");
    }

    @Test
    void displayListOfBooks() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);
        String format = "%-35s %-35s %-35s";
        String headding = String.format(format, "Name", "Author", "Year");

        when(mockIO.getInput()).thenReturn("1").thenReturn("quit");
        library.selectMenu();

        verify(mockIO, times(2)).print("Select an Option From Menu::");
        verify(mockIO).println("Books::");
        verify(mockIO).println(headding);
        verify(mockIO).println(halfGirlFriend.stringRepresentation());
        verify(mockIO).println(loveStory.stringRepresentation());
        verify(mockIO).println(firstLove.stringRepresentation());
    }

    @Test
    void displayInvalidOption() {
        Biblioteca library = new Biblioteca(mockIO, new ArrayList<>());
        String expectedMessage = "Invalid Option";

        when(mockIO.getInput()).thenReturn("3").thenReturn("quit");
        library.selectMenu();

        verify(mockIO, times(2)).print("Select an Option From Menu::");
        verify(mockIO).println(expectedMessage);
    }

    @Test
    void executeUntilQuit() {
        Biblioteca library = new Biblioteca(mockIO, new ArrayList<>());

        when(mockIO.getInput()).thenReturn("quit");

        library.selectMenu();
        verify(mockIO, times(1)).print("Select an Option From Menu::");
    }

    @Nested
    class CheckOut {

        @Test
        void checkOutABook() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            Book loveStory = new Book("Love Story", "Erich Segal", 1970);
            Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
            List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
            Biblioteca library = new Biblioteca(mockIO, books);

            Book checkOutABook = library.checkOutABook("Love Story");
            assertEquals(loveStory, checkOutABook);
        }

        @Test
        void displayThankYouMessageAfterSuccessfulCheckOutABook() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            List<Book> books = Collections.singletonList(halfGirlFriend);
            Biblioteca library = new Biblioteca(mockIO, books);

            when(mockIO.getInput()).thenReturn("2").thenReturn("half girlFriend").thenReturn("quit");
            library.selectMenu();

            verify(mockIO, times(2)).print("Select an Option From Menu::");
            verify(mockIO).print("Enter a Book Name to check Out::");
            verify(mockIO).print("Thank you! Enjoy the book");
        }

        @Test
        void removeBookFromLibraryAfterCheckOut() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            Book loveStory = new Book("Love Story", "Erich Segal", 1970);
            List<Book> books = Arrays.asList(halfGirlFriend, loveStory);
            Biblioteca library = new Biblioteca(mockIO, books);
            String format = "%-35s %-35s %-35s";
            String headding = String.format(format, "Name", "Author", "Year");

            when(mockIO.getInput()).thenReturn("2").thenReturn("Love Story").thenReturn("1").
                    thenReturn("quit");
            library.selectMenu();

            verify(mockIO, times(3)).print("Select an Option From Menu::");
            verify(mockIO).print("Enter a Book Name to check Out::");
            verify(mockIO).println("Books::");
            verify(mockIO).println(headding);
            verify(mockIO).println(halfGirlFriend.stringRepresentation());
        }

        @Test
        void displayBookNotAvailableAfterUnSuccessfulCheckOutABook() {
            Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
            List<Book> books = Collections.singletonList(halfGirlFriend);
            Biblioteca library = new Biblioteca(mockIO, books);

            when(mockIO.getInput()).thenReturn("2").thenReturn("girlFriend").thenReturn("quit");
            library.selectMenu();

            verify(mockIO, times(2)).print("Select an Option From Menu::");
            verify(mockIO).print("Enter a Book Name to check Out::");
            verify(mockIO).println("That book is not available");
        }

    }

}

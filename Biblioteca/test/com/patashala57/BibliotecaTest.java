package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
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
    void printWelcomeMessage() {
        Biblioteca aBiblioteca = new Biblioteca(mockIO);

        aBiblioteca.printWelcomeMessage();

        verify(mockIO).display("Welcome To Bangalore Public Library");
    }

    @Test
    void printNoBooksAvailableWhenThereAreNoBooks() {
        List<Book> books = new ArrayList<>();
        Biblioteca library = new Biblioteca(mockIO, books);

        when(mockIO.getInput()).thenReturn("1").thenReturn("quit");
        library.selectMenu();

        verify(mockIO).display("No Books Available\n");
    }

    @Test
    void printSingleBook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<Book> books = Collections.singletonList(halfGirlFriend);
        Biblioteca library = new Biblioteca(mockIO, books);
        String expectedMessage = String.format("Books::\n%-35s %-35s %-35s", "Name", "Author", "Year") +
                "\n\n" + halfGirlFriend.stringRepresentation() + "\n";

        when(mockIO.getInput()).thenReturn("1").thenReturn("quit");
        library.selectMenu();

        verify(mockIO).display(expectedMessage);
    }

    @Test
    void displayMenu() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);

        library.menu();
        verify(mockIO).display("Menu::\n1->List Books\n2->checkout a book\nquit->Quit\n");
    }

    @Test
    void displayListOfBooks() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);
        String expectedMessage = String.format("Books::\n%-35s %-35s %-35s", "Name", "Author", "Year") +
                "\n\n" + halfGirlFriend.stringRepresentation() + "\n" +
                loveStory.stringRepresentation() + "\n" +
                firstLove.stringRepresentation() + "\n";

        when(mockIO.getInput()).thenReturn("1").thenReturn("quit");
        library.selectMenu();

        verify(mockIO,times(2)).display("Select an Option From Menu::");
        verify(mockIO).display(expectedMessage);
    }

    @Test
    void expectedInvalidOption() {
        Biblioteca library = new Biblioteca(mockIO, new ArrayList<>());
        String expectedMessage = "Invalid Option";

        when(mockIO.getInput()).thenReturn("3").thenReturn("quit");
        library.selectMenu();

        verify(mockIO,times(2)).display("Select an Option From Menu::");
        verify(mockIO).display(expectedMessage);
    }

    @Test
    void executeUntilQuit() {
        Biblioteca library = new Biblioteca(mockIO, new ArrayList<>());

        when(mockIO.getInput()).thenReturn("quit");

        library.selectMenu();
        verify(mockIO,times(1)).display("Select an Option From Menu::");
    }

    @Test
    void checkOutABook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);

        when(mockIO.getInput()).thenReturn("Love Story").thenReturn("quit");
        Book checkOutABook = library.checkOutABook();

        verify(mockIO).display("Enter a Book Name to check Out::");
        assertEquals(loveStory, checkOutABook);
    }

    @Test
    void displayThankYouMessageAfterSuccessfulCheckOutABook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<Book> books = Collections.singletonList(halfGirlFriend);
        Biblioteca library = new Biblioteca(mockIO, books);

        when(mockIO.getInput()).thenReturn("2").thenReturn("half girlFriend").thenReturn("quit");
        library.selectMenu();

        verify(mockIO).display("Enter a Book Name to check Out::");
        verify(mockIO).display("Thank you! Enjoy the book");
    }

    @Test
    void displayMessageAfterUnSuccessfulCheckOutABook() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<Book> books = Collections.singletonList(halfGirlFriend);
        Biblioteca library = new Biblioteca(mockIO, books);

        when(mockIO.getInput()).thenReturn("2").thenReturn("girlFriend").thenReturn("quit");
        library.selectMenu();

        verify(mockIO).display("Enter a Book Name to check Out::");
        verify(mockIO).display("That book is not available");
    }

}

package com.patashala57;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {

    @Test
    void printWelcomeMessage() {
        IO mockIO = mock(IO.class);
        Biblioteca aBiblioteca = new Biblioteca(mockIO);

        aBiblioteca.printWelcomeMessage();

        verify(mockIO).display("Welcome To Bangalore Public Library");
    }

    @Test
    void printNoBooksAvailableWhenThereAreNoBooksInLibrary() {
        IO mockIO = mock(IO.class);
        List<Book> books = new ArrayList<>();
        Biblioteca library = new Biblioteca(mockIO, books);

        library.printBooks();

        verify(mockIO).display("No Books Available\n");
    }

    @Test
    void printSingleBook() {
        IO mockIO = mock(IO.class);
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        List<Book> books = Collections.singletonList(halfGirlFriend);
        Biblioteca library = new Biblioteca(mockIO, books);
        String expectedMessage = String.format("Books::\n%-35s %-35s %-35s", "Name", "Author", "Year") +
                "\n\n" + halfGirlFriend.stringRepresentation() + "\n";

        library.printBooks();

        verify(mockIO).display(expectedMessage);
    }

    @Test
    void printMultipleBooks() {
        IO mockIO = mock(IO.class);
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);
        String expectedMessage = String.format("Books::\n%-35s %-35s %-35s", "Name", "Author", "Year") +
                "\n\n" + halfGirlFriend.stringRepresentation() + "\n" +
                loveStory.stringRepresentation() + "\n" +
                firstLove.stringRepresentation() + "\n";

        library.printBooks();

        verify(mockIO).display(expectedMessage);
    }

}

package com.patashala57;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    void printNoBook() {
        IO mockIO = mock(IO.class);
        List<Book> books = new ArrayList<>();
        Biblioteca library = new Biblioteca(mockIO, books);

        library.printBooks();

        verify(mockIO).display("No Books Available\n");
    }

    @Test
    void printSingleBook() {
        IO mockIO = mock(IO.class);
        Book halfGirlFriend = new Book("Half GirlFriend");
        List<Book> books = Arrays.asList(halfGirlFriend);
        Biblioteca library = new Biblioteca(mockIO, books);

        library.printBooks();

        verify(mockIO).display("Books::\nHalf GirlFriend\n");
    }

    @Test
    void printMultipleBooks() {
        IO mockIO = mock(IO.class);
        Book halfGirlFriend = new Book("Half GirlFriend");
        Book loveStory = new Book("Love Story");
        Book firstLove = new Book("First Love");
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);
        Biblioteca library = new Biblioteca(mockIO, books);

        library.printBooks();

        verify(mockIO).display("Books::\nHalf GirlFriend\nLove Story\nFirst Love\n");
    }

}

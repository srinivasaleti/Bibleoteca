package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListBooksCommandTest {

    private IO mockIO;
    private Biblioteca biblioteca;
    private ListBooksCommand listBooks;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        biblioteca = mock(Biblioteca.class);
        listBooks = new ListBooksCommand(biblioteca, mockIO);
    }

    @Test
    void displayNoBooks() {
        String noBooksAvailale = "No Books Available";

        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(true);
        listBooks.execute();

        verify(mockIO).println(noBooksAvailale);
    }

    @Test
    void displayHeader() {
        String BOOKS = "Books::";
        String format = "%-35s %-35s %-35s";
        String name = "Name";
        String author = "Author";
        String yearPublished = "Year Published";
        String header = String.format(format, name, author, yearPublished);

        listBooks.execute();

        verify(mockIO).println(BOOKS);
        verify(mockIO).println(header);
    }

    @Test
    void displayAllBooksInBiblioteca() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);

        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(biblioteca.stringRepresentationOfItems(Book.class)).
                thenReturn(halfGirlFriend.stringRepresentation());
        listBooks.execute();

        verify(mockIO).println(halfGirlFriend.stringRepresentation());
    }

}

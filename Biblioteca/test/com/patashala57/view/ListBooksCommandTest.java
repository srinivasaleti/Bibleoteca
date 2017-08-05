package com.patashala57.view;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;
import com.patashala57.view.ListBooksCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListBooksCommandTest {

    private IO mockIO;
    private Library library;
    private ListBooksCommand listBooks;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        library = mock(Library.class);
        listBooks = new ListBooksCommand(library, mockIO);
    }

    @Test
    void displayNoBooks() {
        String noBooksAvailable = "No Books Available";

        when(library.isNoItemsAvailable(Book.class)).thenReturn(true);
        listBooks.execute();

        verify(mockIO).println(noBooksAvailable);
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

        when(library.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(library.stringRepresentationOfItems(Book.class)).
                thenReturn(halfGirlFriend.stringRepresentation());
        listBooks.execute();

        verify(mockIO).println(halfGirlFriend.stringRepresentation());
    }

}

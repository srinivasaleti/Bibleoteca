package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListBooksCommandTest {

    private IO mockIO;
    private Library library;
    private ListBooksCommand listBooks;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Library.class);
        this.listBooks = new ListBooksCommand(this.library, this.mockIO);
    }

    @Test
    void displayNoBooks() {
        String noBooksAvailable = "No Books Available";

        when(this.library.isEmpty(Book.class)).thenReturn(true);
        this.listBooks.execute();

        verify(this.mockIO).println(noBooksAvailable);
    }

    @Test
    void displayHeader() {
        String Books = "Books::";
        String format = "%-35s %-35s %-35s";
        String name = "Name";
        String author = "Author";
        String yearPublished = "Year Published";
        String header = String.format(format, name, author, yearPublished);

        this.listBooks.execute();

        verify(this.mockIO).println(Books);
        verify(this.mockIO).println(header);
    }

    @Test
    void displayAllBooksInBiblioteca() {
        String name = "Half GirlFriend";
        String author = "Chetan Bhagat";
        int yearPublished = 2014;
        Book halfGirlFriend = new Book(name, author, yearPublished);

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.stringRepresentationOfItems(Book.class)).
                thenReturn(halfGirlFriend.stringRepresentation());
        this.listBooks.execute();

        verify(this.mockIO).println(halfGirlFriend.stringRepresentation());
    }

}

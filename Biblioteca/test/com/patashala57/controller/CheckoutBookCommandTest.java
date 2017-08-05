package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutBookCommandTest {

    private IO mockIO;
    private CheckoutBookCommand checkoutBookCommand;
    private Library library;

    @BeforeEach
    void beforeEach() {
        library = mock(Library.class);
        mockIO = mock(IO.class);
        checkoutBookCommand = new CheckoutBookCommand(library, mockIO);
    }

    @Test
    void displayNoBooksAvailable() {
        String noBooksAvailable = "No Books Available";

        when(library.isEmpty(Book.class)).thenReturn(true);
        this.checkoutBookCommand.execute();

        verify(this.mockIO).println(noBooksAvailable);
    }

    @Test
    void checkoutABook() {
        String bookNameToCheckout = "BookName";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookNameToCheckout))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(bookNameToCheckout);
        this.checkoutBookCommand.execute();

        verify(this.library).checkoutItem(Book.class, "BookName");
    }

    @Test
    void displaySuccessMessageAfterSuccessfulCheckout() {
        String bookNameToCheckOut = "BookName";
        Book book = new Book("name", "author", 1999);
        String successMessage = "Thank you! Enjoy the book";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookNameToCheckOut))
                .thenReturn(java.util.Optional.of(book));
        when(this.mockIO.getInput()).thenReturn(bookNameToCheckOut);
        this.checkoutBookCommand.execute();

        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessageForunSuccessfulCheckout() {
        String bookName = "BookName";
        String unSuccessMessage = "That book is not available";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookName))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(bookName);
        this.checkoutBookCommand.execute();

        verify(this.mockIO).println(unSuccessMessage);
    }

}

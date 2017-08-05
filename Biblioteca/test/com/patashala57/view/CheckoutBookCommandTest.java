package com.patashala57.view;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.CheckoutBookCommand;
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
    void displayNoBooksAvailableMessage() {
        when(library.isNoItemsAvailable(Book.class)).thenReturn(true);
        checkoutBookCommand.execute();

        verify(mockIO).println("No Books Available");
    }

    @Test
    void checkOutABook() {
        String bookNameToCheckOut = "BookName";

        when(library.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(library.checkoutItem(Book.class, bookNameToCheckOut))
                .thenReturn(java.util.Optional.empty());
        when(mockIO.getInput()).thenReturn(bookNameToCheckOut);
        checkoutBookCommand.execute();

        verify(library).checkoutItem(Book.class, "BookName");
    }

    @Test
    void successfulCheckout() {
        String bookNameToCheckOut = "BookName";
        Book book = new Book("name", "author", 1999);
        String successMessage = "Thank you! Enjoy the book";

        when(library.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(library.checkoutItem(Book.class, bookNameToCheckOut))
                .thenReturn(java.util.Optional.of(book));
        when(mockIO.getInput()).thenReturn(bookNameToCheckOut);
        checkoutBookCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void unSuccessfulCheckout() {
        String bookName = "BookName";
        String unSuccessMessage = "That book is not available";

        when(library.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(library.checkoutItem(Book.class, bookName))
                .thenReturn(java.util.Optional.empty());
        when(mockIO.getInput()).thenReturn(bookName);
        checkoutBookCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.User;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutBookCommandTest {

    private IO mockIO;
    private CheckoutBookCommand checkoutBookCommand;
    private Library library;
    private User user;

    @BeforeEach
    void beforeEach() {
        library = mock(Library.class);
        mockIO = mock(IO.class);
        user = new User("1", "1", "1", "1", "1");
        checkoutBookCommand = new CheckoutBookCommand(library, mockIO, user);
    }

    @Test
    void cannotInteractWithLibraryIfNoBooksAvailable() {
        String bookNameToCheckout = "BookName";
        when(this.library.isEmpty(Book.class)).thenReturn(true);

        verify(this.library, never()).checkoutItem(Book.class, bookNameToCheckout,null);
    }

    @Test
    void checkoutABook() {
        String bookNameToCheckout = "BookName";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookNameToCheckout,null))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(bookNameToCheckout);
        this.checkoutBookCommand.execute();

        verify(this.library).checkoutItem(Book.class, bookNameToCheckout,null);
    }

}

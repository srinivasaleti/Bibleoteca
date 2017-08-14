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
    void cannotCheckoutWhenNoBooksAvailable(){
        String bookNameToCheckout = "BookName";
        when(this.library.isEmpty(Book.class)).thenReturn(true);

        verify(this.library,never()).checkoutItem(Book.class,bookNameToCheckout);
    }

    @Test
    void checkoutABook() {
        String bookNameToCheckout = "BookName";

        when(this.library.isEmpty(Book.class)).thenReturn(false);
        when(this.library.checkoutItem(Book.class, bookNameToCheckout))
                .thenReturn(java.util.Optional.empty());
        when(this.mockIO.getInput()).thenReturn(bookNameToCheckout);
        this.checkoutBookCommand.execute();

        verify(this.library).checkoutItem(Book.class, bookNameToCheckout);
    }

}

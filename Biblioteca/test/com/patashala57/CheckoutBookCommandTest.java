package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutBookCommandTest {

    private IO mockIO;
    private CheckoutBookCommand checkoutBookCommand;
    private Biblioteca biblioteca;

    @BeforeEach
    void beforeEach() {
        biblioteca = mock(Biblioteca.class);
        mockIO = mock(IO.class);
        checkoutBookCommand = new CheckoutBookCommand(biblioteca, mockIO);
    }

    @Test
    void displayNoBooksAvailableMessage() {
        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(true);
        checkoutBookCommand.execute();

        verify(mockIO).println("No Books Available");
    }

    @Test
    void readInputFromUser() {
        String enterBookNameToCheckout = "Enter a Book Name to check Out::";

        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(false);
        checkoutBookCommand.execute();

        verify(mockIO).getInput();
        verify(mockIO).print(enterBookNameToCheckout);
    }

    @Test
    void shouldCallCheckoutItemInBibioletca() {
        String bookNameToCheckOut = "BookName";

        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(mockIO.getInput()).thenReturn(bookNameToCheckOut);
        checkoutBookCommand.execute();

        verify(biblioteca).checkoutItem(Book.class, "BookName");
    }

    @Test
    void displaySuccessMessage() {
        String bookNameToCheckOut = "BookName";
        Book book = new Book("name", "author", 1999);
        String successMessage = "Thank you! Enjoy the book";

        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(biblioteca.checkoutItem(Book.class,bookNameToCheckOut)).thenReturn(book);
        when(mockIO.getInput()).thenReturn(bookNameToCheckOut);
        checkoutBookCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessfulMessage(){
        String bookName="BookName";
        String unSuccessMessage = "That book is not available";

        when(biblioteca.isNoItemsAvailable(Book.class)).thenReturn(false);
        when(biblioteca.checkoutItem(Book.class,bookName)).thenReturn(null);
        when(mockIO.getInput()).thenReturn(bookName);
        checkoutBookCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

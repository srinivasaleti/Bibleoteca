package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.User;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class ReturnItemTest {

    private IO mockIO;
    private Library library;
    private ReturnItem returnItem;
    private User currentUser;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Library.class);
        this.currentUser = new User("1", "1", "1", "1", "1");
        this.returnItem = new ReturnItem(this.library, this.mockIO, currentUser);
    }

    @Test
    void readInputFromUserForReturnAItem() {
        String enterItemName = "Enter Item Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Item to return";

        when(this.mockIO.getInput()).thenReturn(enterItemName);
        when(this.library.whoCheckedOut(enterItemName, Book.class)).thenReturn(Optional.empty());
        this.returnItem.returnAItem(Book.class, enterItemName, successMessage, unSuccessMessage);

        verify(this.mockIO).print(enterItemName);
        verify(this.mockIO).getInput();
    }

    @Test
    void returnAnItemToBiblioteca() {
        String itemName = "name";
        String enterItemName = "Enter Item Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Item to return";

        when(this.mockIO.getInput()).thenReturn(itemName);
        when(this.library.whoCheckedOut(itemName, Book.class)).thenReturn(Optional.of(this.currentUser));
        this.returnItem.returnAItem(Book.class, enterItemName, successMessage, unSuccessMessage);

        verify(this.library).returnItem(Book.class, itemName, this.currentUser);
    }

    @Test
    void displayUnSuccessMessageWhenTryToReturnAnItemWhichIsNotYetCheckedOut() {
        String enterItemName = "Enter Item Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Item to return";

        when(this.mockIO.getInput()).thenReturn(enterItemName);
        when(this.library.whoCheckedOut(enterItemName, Book.class)).thenReturn(Optional.empty());
        this.returnItem.returnAItem(Book.class, enterItemName, successMessage, unSuccessMessage);

        verify(this.mockIO).println(unSuccessMessage);
        verify(this.mockIO).getInput();
    }

    @Test
    void displaySuccessfulReturnMessage() {
        String itemName = "name";
        String enterItemName = "Enter Item Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Item to return";

        when(this.mockIO.getInput()).thenReturn(itemName);
        when(this.library.returnItem(Book.class, itemName, this.currentUser)).thenReturn(true);
        when(this.library.whoCheckedOut(itemName, Book.class)).thenReturn(Optional.of(this.currentUser));
        this.returnItem.returnAItem(Book.class, enterItemName, successMessage, unSuccessMessage);

        verify(this.mockIO).println(successMessage);
    }

}
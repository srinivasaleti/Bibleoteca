package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.User;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        this.currentUser=new User("1","1","1","1","1");
        this.returnItem = new ReturnItem(this.library, this.mockIO, currentUser);
    }

    @Test
    void readInputFromUserForReturnAItem() {
        String enterBookName = "Enter Item Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Item to return";

        this.returnItem.returnAItem(Book.class, enterBookName, successMessage, unSuccessMessage);

        verify(this.mockIO).print(enterBookName);
        verify(this.mockIO).getInput();
    }

    @Test
    void returnAnItemToBiblioteca() {
        String bookName = "name";
        String enterBookName = "Enter Book Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Book to return";


        when(this.mockIO.getInput()).thenReturn(bookName);
        this.returnItem.returnAItem(Book.class, enterBookName, successMessage, unSuccessMessage);

        verify(this.library).returnItem(Book.class, bookName);
    }

    @Test
    void displaySuccessfulReturnMessage() {
        String bookName = "name";
        String enterBookName = "Enter Book Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Book to return";

        when(this.mockIO.getInput()).thenReturn(bookName);
        when(this.library.returnItem(Book.class, bookName)).thenReturn(true);
        this.returnItem.returnAItem(Book.class, enterBookName, successMessage, unSuccessMessage);

        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessfulReturnMessage() {
        String bookName = "name";
        String enterBookName = "Enter Book Name to return::";
        String successMessage = "Successfully return";
        String unSuccessMessage = "That is not a valid Book to return";

        when(this.mockIO.getInput()).thenReturn(bookName);
        when(this.library.returnItem(Book.class, bookName)).thenReturn(false);
        this.returnItem.returnAItem(Book.class, enterBookName, successMessage, unSuccessMessage);

        verify(this.mockIO).println(unSuccessMessage);
    }

}
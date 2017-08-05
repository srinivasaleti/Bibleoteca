package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ReturnBookCommandTest {

    private IO mockIO;
    private Library library;
    private ReturnBookCommand returnBookCommand;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Library.class);
        this.returnBookCommand = new ReturnBookCommand(this.library, this.mockIO);
    }

    @Test
    void readInputFromUserForReturnABook() {
        String enterBookName = "Enter Book Name to return::";
        this.returnBookCommand.execute();

        verify(this.mockIO).print(enterBookName);
        verify(this.mockIO).getInput();
    }

    @Test
    void returnBookToBiblioteca() {
        String bookName = "name";

        when(this.mockIO.getInput()).thenReturn(bookName);
        this.returnBookCommand.execute();

        verify(this.library).returnItem(Book.class, bookName);
    }

    @Test
    void displaySuccessfulReturnMessage() {
        String successMessage = "Thank you for returning the book";
        String bookName = "Harry Poter";

        when(this.mockIO.getInput()).thenReturn(bookName);
        when(this.library.returnItem(Book.class, bookName)).thenReturn(true);
        this.returnBookCommand.execute();

        verify(this.mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessfulReturnMessage() {
        String unSuccessMessage = "That is not a valid book to return";
        String bookName = "Harry Poter";

        when(this.mockIO.getInput()).thenReturn(bookName);
        when(this.library.returnItem(Book.class, bookName)).thenReturn(false);
        this.returnBookCommand.execute();

        verify(this.mockIO).println(unSuccessMessage);
    }

}

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
        mockIO = mock(IO.class);
        library = mock(Library.class);
        returnBookCommand = new ReturnBookCommand(library, mockIO);
    }

    @Test
    void readInputFromUserForReturnABook() {
        String enterBookName = "Enter Book Name to return::";
        returnBookCommand.execute();

        verify(mockIO).print(enterBookName);
        verify(mockIO).getInput();
    }

    @Test
    void returnBookToBiblioteca() {
        String bookName = "name";

        when(mockIO.getInput()).thenReturn(bookName);
        returnBookCommand.execute();

        verify(library).returnItem(Book.class, bookName);
    }

    @Test
    void displaySuccessMessage() {
        String successMessage = "Thank you for returning the book";
        String bookName = "Harry Poter";

        when(mockIO.getInput()).thenReturn(bookName);
        when(library.returnItem(Book.class, bookName)).thenReturn(true);
        returnBookCommand.execute();

        verify(mockIO).println(successMessage);
    }

    @Test
    void displayUnSuccessMessage() {
        String unSuccessMessage = "That is not a valid book to return";
        String bookName = "Harry Poter";

        when(mockIO.getInput()).thenReturn(bookName);
        when(library.returnItem(Book.class, bookName)).thenReturn(false);
        returnBookCommand.execute();

        verify(mockIO).println(unSuccessMessage);
    }

}

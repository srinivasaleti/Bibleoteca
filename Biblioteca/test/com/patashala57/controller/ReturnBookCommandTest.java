package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.User;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class ReturnBookCommandTest {

    private IO mockIO;
    private Library library;
    private ReturnBookCommand returnBookCommand;
    private User currentUser;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.library = mock(Library.class);
        this.currentUser=new User("1","1","1","1","1");
        this.returnBookCommand = new ReturnBookCommand(this.library, this.mockIO, this.currentUser);
    }

    @Test
    void returnBookToBiblioteca() {
        String itemName = "name";

        when(this.mockIO.getInput()).thenReturn(itemName);
        when(this.library.whoCheckedOut(itemName, Book.class)).thenReturn(Optional.of(this.currentUser));
        this.returnBookCommand.execute();

        verify(this.library).returnItem(Book.class, itemName, this.currentUser);
    }

}

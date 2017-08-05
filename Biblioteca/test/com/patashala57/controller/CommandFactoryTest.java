package com.patashala57.controller;

import com.patashala57.model.Biblioteca;
import com.patashala57.model.Library;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CommandFactoryTest {

    private CommandFactory factory;

    @BeforeEach
    void beforeEach() {
        IO mockIO = mock(IO.class);
        Library library = new Biblioteca(null);
        factory = new CommandFactory(library, mockIO);
    }

    @Test
    void expectedListBooksCommand() {
        String listBooksCommand = "1";
        Class expected = ListBooksCommand.class;

        assertEquals(expected, factory.getCommand(listBooksCommand).getClass());
    }

    @Test
    void expectedCheckoutBookCommand() {
        String checkOutBookCommand = "2";
        Class expected = CheckoutBookCommand.class;

        assertEquals(expected, factory.getCommand(checkOutBookCommand).getClass());
    }

    @Test
    void expectedReturnBookCommand() {
        String returnBookCommand = "3";
        Class expected = ReturnBookCommand.class;

        assertEquals(expected, factory.getCommand(returnBookCommand).getClass());
    }

    @Test
    void expectedListMovieCommand() {
        String listMovies = "4";
        Class expected = ListMoviesCommand.class;

        assertEquals(expected, factory.getCommand(listMovies).getClass());
    }

    @Test
    void expectedCheckoutMovieCommand() {
        String checkoutMovie = "5";
        Class expected = CheckoutMovieCommand.class;

        assertEquals(expected, factory.getCommand(checkoutMovie).getClass());
    }

    @Test
    void expectedQuitCommand() {
        String quitCommand = "quit";
        Class expected = QuitCommand.class;

        assertEquals(expected, factory.getCommand(quitCommand).getClass());
    }

    @Test
    void expectedInvalidCommand() {
        String invalidCommand = "invalid";
        Class expected = InvalidCommand.class;

        assertEquals(expected, factory.getCommand(invalidCommand).getClass());
    }

}

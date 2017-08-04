package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;

class CommandFactoryTest {

    IO mockIO;
    Biblioteca biblioteca;
    CommandFactory factory;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        biblioteca = new Biblioteca(mockIO, null);
        factory = new CommandFactory(biblioteca, mockIO);
    }

    @Test
    void expectedListBooksCommand() {
        String listBooksCommand = "1";
        Class expected = ListBooksCommand.class;

        Command listBooks = factory.getCommand(listBooksCommand);

        assertEquals(expected, listBooks.getClass());
    }

    @Test
    void expectedCheckOutBookCommand() {
        String checkOutBookCommand = "2";
        Class expected = CheckoutBookCommand.class;

        Command checkOutBook = factory.getCommand(checkOutBookCommand);

        assertEquals(expected, checkOutBook.getClass());
    }

    @Test
    void expectedReturnBookCommand() {
        String returnBookCommand = "3";
        Class expected = ReturnBookCommand.class;

        Command returnBook = factory.getCommand(returnBookCommand);

        assertEquals(expected, returnBook.getClass());
    }

    @Test
    void expectedListMovieCommand() {
        String listMovies = "4";
        Class expected = ListMoviesCommand.class;

        Command listMoviesCommand = factory.getCommand(listMovies);

        assertEquals(expected, listMoviesCommand.getClass());
    }

    @Test
    void expectedCheckOutMovieCommand() {
        String checkoutMovie = "5";
        Class expected = CheckoutMovieCommand.class;

        Command checkoutMovieCommand = factory.getCommand(checkoutMovie);

        assertEquals(expected, checkoutMovieCommand.getClass());
    }

    @Test
    void expectedQuitCommand() {
        String quitCommand = "quit";
        Class expected = QuitCommand.class;

        Command quit = factory.getCommand(quitCommand);

        assertEquals(expected, quit.getClass());
    }

    @Test
    void expectedInvalidCommand() {
        String invalidCommand = "invalid";
        Class expected = InvalidCommand.class;

        Command invalid = factory.getCommand(invalidCommand);

        assertEquals(expected, invalid.getClass());
    }

}

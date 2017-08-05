package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CommandFactoryTest {

    IO mockIO;
    private CommandFactory factory;

    @BeforeEach
    void beforeEach() {
        mockIO = mock(IO.class);
        Biblioteca biblioteca = new Biblioteca(null);
        factory = new CommandFactory(biblioteca, mockIO);
    }

    @Test
    void expectedListBooksCommand() {
        String listBooksCommand = "1";
        Class expected = ListBooksCommand.class;

        factory.loadMaps();
        Command listBooks = factory.getCommand(listBooksCommand);

        assertEquals(expected, listBooks.getClass());
    }

    @Test
    void expectedCheckOutBookCommand() {
        String checkOutBookCommand = "2";
        Class expected = CheckoutBookCommand.class;

        factory.loadMaps();
        Command checkOutBook = factory.getCommand(checkOutBookCommand);

        assertEquals(expected, checkOutBook.getClass());
    }

    @Test
    void expectedReturnBookCommand() {
        String returnBookCommand = "3";
        Class expected = ReturnBookCommand.class;

        factory.loadMaps();
        Command returnBook = factory.getCommand(returnBookCommand);

        assertEquals(expected, returnBook.getClass());
    }

    @Test
    void expectedListMovieCommand() {
        String listMovies = "4";
        Class expected = ListMoviesCommand.class;

        factory.loadMaps();
        Command listMoviesCommand = factory.getCommand(listMovies);

        assertEquals(expected, listMoviesCommand.getClass());
    }

    @Test
    void expectedCheckOutMovieCommand() {
        String checkoutMovie = "5";
        Class expected = CheckoutMovieCommand.class;

        factory.loadMaps();
        Command checkoutMovieCommand = factory.getCommand(checkoutMovie);

        assertEquals(expected, checkoutMovieCommand.getClass());
    }

    @Test
    void expectedQuitCommand() {
        String quitCommand = "quit";
        Class expected = QuitCommand.class;

        factory.loadMaps();
        Command quit = factory.getCommand(quitCommand);

        assertEquals(expected, quit.getClass());
    }

    @Test
    void expectedInvalidCommand() {
        String invalidCommand = "invalid";
        Class expected = InvalidCommand.class;

        factory.loadMaps();
        Command invalid = factory.getCommand(invalidCommand);

        assertEquals(expected, invalid.getClass());
    }

}

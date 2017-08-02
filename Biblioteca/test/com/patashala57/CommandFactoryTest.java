package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandFactoryTest {

    @Test
    void expectedListBooksCommand() {
        String listBooksCommand = "1";
        Class expected = ListBooksCommand.class;

        Command listBooks = CommandFactory.getCommand(listBooksCommand);

        assertEquals(expected, listBooks.getClass());
    }

    @Test
    void expectedCheckOutBookCommand() {
        String checkOutBookCommand = "2";
        Class expected = CheckOutBook.class;

        Command checkOutBook = CommandFactory.getCommand(checkOutBookCommand);

        assertEquals(expected, checkOutBook.getClass());
    }

    @Test
    void expectedReturnBookCommand() {
        String returnBookCommand = "3";
        Class expected = ReturnBookCommand.class;

        Command returnBook = CommandFactory.getCommand(returnBookCommand);

        assertEquals(expected, returnBook.getClass());
    }

    @Test
    void expectedQuitCommand() {
        String quitCommand = "quit";
        Class expected = QuitCommand.class;

        Command quit = CommandFactory.getCommand(quitCommand);

        assertEquals(expected, quit.getClass());
    }

    @Test
    void expectedInvalidCommand() {
        String invalidCommand = "invalid";
        Class expected = InvalidCommand.class;

        Command invalid = CommandFactory.getCommand(invalidCommand);

        assertEquals(expected, invalid.getClass());
    }

}

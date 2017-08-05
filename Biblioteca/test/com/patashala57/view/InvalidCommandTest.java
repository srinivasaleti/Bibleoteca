package com.patashala57.view;

import com.patashala57.view.IO;
import com.patashala57.view.InvalidCommand;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InvalidCommandTest {

    @Test
    void shouldPrintInvalidMessage() {
        IO mockIO=mock(IO.class);
        InvalidCommand invalid = new InvalidCommand(mockIO);
        String invalidBook = "Invalid Option";

        invalid.execute();

        verify(mockIO).println(invalidBook);
    }

}
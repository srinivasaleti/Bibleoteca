package com.patashala57.view;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuitCommandTest {

    @Test
    void displayQuitMessage() {
        IO mockIO = mock(IO.class);
        QuitCommand quitCommand = new QuitCommand(mockIO);
        String message = "Thank you for your valuable time";

        quitCommand.execute();

        verify(mockIO).println(message);
    }

}

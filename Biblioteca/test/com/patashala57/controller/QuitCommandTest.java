package com.patashala57.controller;

import com.patashala57.view.IO;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuitCommandTest {

    @Test
    void displayThankYouMessage() {
        IO mockIO = mock(IO.class);
        QuitCommand quitCommand = new QuitCommand(mockIO);
        String message = "Thank you for your valuable time";

        quitCommand.execute();

        verify(mockIO).println(message);
    }

}

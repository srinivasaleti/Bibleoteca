package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {

    @Test
    void printWelcomeMessage() {
        IO mockIO = mock(IO.class);
        new Biblioteca(mockIO);

        verify(mockIO).display("Welcome To Bangalore Public Library");
    }

}

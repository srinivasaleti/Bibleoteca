package com.patashala57;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaTest {

    @Test
    void printWelcomeMessage() {
        PrintStream out = mock(System.out.getClass());
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.printWelcomeMessage(out);

        verify(out).println("Welcome To Bangalore Public Library");
    }

}

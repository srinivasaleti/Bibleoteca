package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InvalidCommandTest {

    @Test
    void shouldCallInvalidMethod() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        InvalidCommand invalid = new InvalidCommand();

        invalid.execute(biblioteca);

        verify(biblioteca).invalid();
    }

}

package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ReturnBookTest {

    @Test
    void shouldCallReturnBookMethod() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        ReturnBookCommand returnBook = new ReturnBookCommand();

        returnBook.execute(biblioteca);

        verify(biblioteca).readInputToReturn();
    }

}

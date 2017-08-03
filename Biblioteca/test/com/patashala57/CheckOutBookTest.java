package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CheckOutBookTest {

    @Test
    void shouldCallCheckOutMethod() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckOutBook checkOutBook = new CheckOutBook();

        checkOutBook.execute(biblioteca);

        verify(biblioteca).checkout();
    }

}

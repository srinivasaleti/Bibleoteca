package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CheckOutMovieCommandTest {

    @Test
    void shouldCallCheckOutMethodOfBibiloteca() {
        CheckOutMovieCommand checkOutMovie = new CheckOutMovieCommand();
        Biblioteca biblioteca = mock(Biblioteca.class);

        checkOutMovie.execute(biblioteca);

        verify(biblioteca).checkout();
    }

}

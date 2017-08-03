package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListMoviesCommandTest {

    @Test
    void shouldCallDisplayAllItemsBibiloteca() {
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand();
        Biblioteca biblioteca = mock(Biblioteca.class);

        listMoviesCommand.execute(biblioteca);

        verify(biblioteca).displayAllItems();
    }

}

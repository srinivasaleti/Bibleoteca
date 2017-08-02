package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksTest {

    @Test
    void shouldCallListBookMethod() {
        Biblioteca bibilotica = mock(Biblioteca.class);
        ListBooksCommand listBooks = new ListBooksCommand();

        listBooks.execute(bibilotica);

        verify(bibilotica).displayAllBooks();
    }

}

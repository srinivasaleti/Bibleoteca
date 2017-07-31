package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void returnsExactNameOfTheBook() {
        Book aBook = new Book("Half girlFriend");

        assertEquals("Half girlFriend", aBook.toString());
    }

    @Test
    void returnsExactNameOfAnotherTheBook() {
        Book aBook = new Book("Love Story");

        assertEquals("Love Story", aBook.toString());
    }

}

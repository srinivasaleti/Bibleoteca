package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void expectedDetailsTheBook() {
        Book aBook = new Book("Love Story","Erich Segal",1970);
        String expected = String.format("%-35s %-35s %-35s", "Love Story", "Erich Segal", 1970);

        assertEquals(expected, aBook.stringRepresentation());
    }

    @Test
    void expectedDetailsOfLoveStory() {
        Book aBook = new Book("Love Story","Segal",1970);
        String expected = String.format("%-35s %-35s %-35s", "Love Story", "Segal", 1970);

        assertEquals(expected, aBook.stringRepresentation());
    }

}

package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

    @Test
    void displayDetailsTheBook() {
        Book aBook = new Book("Love Story", "Erich Segal", 1970);
        String expected = String.format("%-35s %-35s %-35s", "Love Story", "Erich Segal", 1970);

        assertEquals(expected, aBook.stringRepresentation());
    }

    @Test
    void displayDetailsOfLoveStory() {
        Book aBook = new Book("Love Story", "Segal", 1970);
        String expected = String.format("%-35s %-35s %-35s", "Love Story", "Segal", 1970);

        assertEquals(expected, aBook.stringRepresentation());
    }

    @Test
    void displayBookName() {
        Book aBook = new Book("Love Story", "Segal", 1970);

        assertEquals("Love Story", aBook.name());
    }

    @Test
    void displayTrueLoveForTrueLoveBook() {
        Book aBook = new Book("True Love", "Segal", 1975);
        String expected = "True Love";

        assertEquals(expected, aBook.name());
    }

    @Test
    void bookNotEqualToNull() {
        Book aBook = new Book("Love Story", "Segal", 1970);

        assertNotEquals(null, aBook);
    }

    @Test
    void bookNotEqualToString() {
        Book aBook = new Book("Love Story", "Segal", 1970);
        String unexpected = "srinu";

        assertNotEquals(unexpected,aBook);
    }

    @Test
    void bookEqualToItSelf() {
        Book aBook = new Book("True Love", "Segal", 1970);
        Book sameBook = new Book("True Love", "Segal", 1970);

        assertEquals(aBook, sameBook);
    }


    @Test
    void trueLoveBookEqualToTrueLove() {
        Book aBook = new Book("True Love", "Segal", 1970);
        Book sameBook = new Book("True Love", "Segal", 1970);

        assertEquals(aBook, sameBook);
    }

}

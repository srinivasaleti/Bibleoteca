package com.patashala57.model;

import com.patashala57.model.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void bookNotEqualToNull() {
        Book aBook = new Book("Love Story", "Segal", 1970);

        assertNotEquals(null, aBook);
    }

    @Test
    void bookNotEqualToString() {
        Book aBook = new Book("Love Story", "Segal", 1970);
        String unexpected = "aBook";

        assertNotEquals(unexpected, aBook);
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

    @Test
    void givenNameEqualToBookName() {
        Book aBook = new Book("True Love", "Segal", 1970);
        String givenName = "True Love";

        assertTrue(aBook.isSameName(givenName));
    }

    @Test
    void givenNameIsNotEqualToBookName() {
        Book aBook = new Book("True Love", "Segal", 1970);
        String givenName = "First Love";

        assertFalse(aBook.isSameName(givenName));
    }

    @Test
    void stringRepresentationOfHalfGirlFriend() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        String format = "%-35s %-35s %-35s";
        String expected = String.format(format, "Half GirlFriend", "Chetan Bhagat", 2014);

        assertEquals(halfGirlFriend.stringRepresentation(), expected);
    }

    @Test
    void stringRepresentationOfTrueLove() {
        Book trueLove = new Book("True Love", "Chetan Bhagat", 2014);
        String format = "%-35s %-35s %-35s";
        String expected = String.format(format, "True Love", "Chetan Bhagat", 2014);

        assertEquals(trueLove.stringRepresentation(), expected);
    }

}

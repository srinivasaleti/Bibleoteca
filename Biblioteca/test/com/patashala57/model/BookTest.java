package com.patashala57.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void bookNotEqualToNull() {
        String name = "Love Story";
        String author = "Segal";
        int yearPublished = 1970;
        Book aBook = new Book(name, author, yearPublished);

        assertNotEquals(null, aBook);
    }

    @Test
    void bookNotEqualToString() {
        String name = "Love Story";
        String author = "Segal";
        int yearPublished = 1970;
        Book aBook = new Book(name, author, yearPublished);
        String unexpected = "aBook";

        assertNotEquals(unexpected, aBook);
    }

    @Test
    void bookEqualToItSelf() {
        String name = "True Love";
        String author = "Segal";
        int yearPublished = 1970;
        String sameName = "True Love";
        String sameAuthor = "Segal";
        int sameYearPusblished = 1970;
        Book aBook = new Book(name, author, yearPublished);
        Book sameBook = new Book(sameName, sameAuthor, sameYearPusblished);

        assertEquals(aBook, sameBook);
    }

    @Test
    void trueLoveBookEqualToTrueLove() {
        String name = "True Love";
        String author = "Segal";
        int yearPublished = 1970;
        Book aBook = new Book(name, author, yearPublished);
        Book sameBook = new Book(name, author, yearPublished);

        assertEquals(aBook, sameBook);
    }

    @Test
    void givenNameEqualToBookName() {
        String givenName = "True Love";
        String name = "True Love";
        String author = "Segal";
        int yearPublished = 1970;
        Book aBook = new Book(name, author, yearPublished);

        assertTrue(aBook.isSameName(givenName));
    }

    @Test
    void givenNameIsNotEqualToBookName() {
        String name = "True Love";
        String author = "Segal";
        int yearPublished = 1970;
        String givenName = "First Love";
        Book aBook = new Book(name, author, yearPublished);

        assertFalse(aBook.isSameName(givenName));
    }

    @Test
    void stringRepresentationOfHalfGirlFriend() {
        String name = "Half GirlFriend";
        String author = "Chetan Bhagat";
        int yearPublished = 2014;
        Book halfGirlFriend = new Book(name, author, yearPublished);
        String format = "%-35s %-35s %-35s";
        String expected = String.format(format, name, author, yearPublished);

        assertEquals(halfGirlFriend.stringRepresentation(), expected);
    }

    @Test
    void stringRepresentationOfTrueLove() {
        String name = "True Love";
        String author = "Chetan Bhagat";
        int yearPublished = 2014;
        Book trueLove = new Book(name, author, yearPublished);
        String format = "%-35s %-35s %-35s";
        String expected = String.format(format, name, author, yearPublished);

        assertEquals(trueLove.stringRepresentation(), expected);
    }

}

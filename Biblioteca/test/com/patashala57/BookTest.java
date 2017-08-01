package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @Test
    void expectedBookName(){
        Book aBook = new Book("Love Story","Segal",1970);

        assertEquals("Love Story",aBook.name());
    }

    @Test
    void expectedTrueLoveForTrueLoveBook(){
        Book aBook = new Book("True Love","Segal",1975);

        assertEquals("True Love",aBook.name());
    }

    @Test
    void bookIsNotEqualToNull(){
        Book aBook = new Book("Love Story","Segal",1970);

        assertNotEquals(aBook,null);
    }

    @Test
    void bookNotEqualToString(){
        Book aBook = new Book("Love Story","Segal",1970);

        assertNotEquals(aBook,"srinu");
    }

    @Test
    void bookEqualToItSelf(){
        Book aBook = new Book("True Love","Segal",1970);
        Book sameBook = new Book("True Love","Segal",1970);

        assertEquals(aBook,sameBook);
    }


    @Test
    void trueLoveBookEqualToTrueLove(){
        Book aBook = new Book("True Love","Segal",1970);
        Book sameBook = new Book("True Love","Segal",1970);

        assertEquals(aBook,sameBook);
    }

}

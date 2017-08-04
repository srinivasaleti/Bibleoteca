package com.patashala57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void movieIsNotEqualToNull() {
        Movie movie = new Movie("Titanic", 1997, "Cameron", "9");

        assertNotEquals(movie, null);
    }

    @Test
    void movieIsNotEqualToString() {
        Movie aMovie = new Movie("Titanic", 1997, "Cameron", "9");
        String movie = "movie";

        assertNotEquals(movie, aMovie);
    }

    @Test
    void movieIsEqualToSameMovie() {
        Movie aMovie = new Movie("Titanic", 1997, "Cameron", "9");

        assertEquals(aMovie, aMovie);
    }

    @Test
    void movieIsEqualSameMovie() {
        Movie aMovie = new Movie("Titanic", 1997, "Cameron", "9");
        Movie sameMovie = new Movie("Titanic", 1997, "Cameron", "9");

        assertEquals(aMovie, sameMovie);
    }

    @Test
    void givenNameIsEqualToMovieName() {
        Movie aMovie = new Movie("Titanic", 1997, "Cameron", "9");
        String titanic = "TitanIc";

        assertTrue(aMovie.isSameName(titanic));
    }

    @Test
    void givenNameIsNotEqualToMovieName() {
        Movie aMovie = new Movie("Titanic", 1997, "Cameron", "9");
        String loveFail = "Love fail";

        assertFalse(aMovie.isSameName(loveFail));
    }

    @Test
    void stringRepresentationOfTitanic() {
        String format = "%-35s %-35s %-35s %-35d";
        Movie aMovie = new Movie("Titanic", 1997, "Cameron", "9");
        String name = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";

        String expected = String.format(format, name, director, rating, yearReleased);

        assertEquals(expected, aMovie.stringRepresentation());
    }

    @Test
    void stringRepresentationOfTwilight() {
        String format = "%-35s %-35s %-35s %-35d";
        Movie aMovie = new Movie("Twilight", 2009, "HardWicke", "8");
        String name = "Twilight";
        int yearReleased = 2009;
        String director = "HardWicke";
        String rating = "8";

        String expected = String.format(format, name, director, rating, yearReleased);

        assertEquals(expected, aMovie.stringRepresentation());
    }

}

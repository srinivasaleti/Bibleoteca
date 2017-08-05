package com.patashala57.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void movieIsNotEqualToNull() {
        String name = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";
        Movie movie = new Movie(name, yearReleased, director, rating);

        assertNotEquals(movie, null);
    }

    @Test
    void movieIsNotEqualToString() {
        String name = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";
        Movie aMovie = new Movie(name, yearReleased, director, rating);
        String movie = "movie";

        assertNotEquals(movie, aMovie);
    }

    @Test
    void movieIsEqualToItSelf() {
        String name = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";
        Movie aMovie = new Movie(name, yearReleased, director, rating);

        assertEquals(aMovie, aMovie);
    }

    @Test
    void movieIsEqualToSameMovie() {
        String name = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";
        Movie aMovie = new Movie(name, yearReleased, director, rating);
        Movie sameMovie = new Movie(name, yearReleased, director, rating);

        assertEquals(aMovie, sameMovie);
    }

    @Test
    void givenNameIsEqualToMovieName() {
        String givenName = "Titanic";
        String titanic = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";
        Movie aMovie = new Movie(titanic, yearReleased, director, rating);

        assertTrue(aMovie.isSameName(givenName));
    }

    @Test
    void givenNameIsNotEqualToMovieName() {
        String givenName = "Love fail";
        String titanic = "Titanic";
        int yearReleased = 1997;
        String director = "Cameron";
        String rating = "9";
        Movie aMovie = new Movie(titanic, yearReleased, director, rating);

        assertFalse(aMovie.isSameName(givenName));
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

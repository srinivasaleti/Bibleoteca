package com.patashala57.model;

//Represents a film
public class Movie implements LibraryItem {

    private final String name;
    private final int yearReleased;
    private final String director;
    private final String rating;

    public Movie(String name, int yearReleased, String director, String rating) {
        this.name = name;
        this.yearReleased = yearReleased;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(this.getClass().equals(other.getClass()))) {
            return false;
        }
        Movie that = (Movie) other;
        return this.name.equals(that.name) &&
                this.director.equals(that.director) &&
                this.yearReleased == that.yearReleased &&
                this.rating.equals(that.rating);
    }

    @Override
    public String stringRepresentation() {
        String format = "%-35s %-35s %-35s %-35d";
        return String.format(format, this.name, this.director, this.rating, this.yearReleased);
    }

    @Override
    public boolean isSameName(String name) {
        return this.name.equalsIgnoreCase(name);
    }

}

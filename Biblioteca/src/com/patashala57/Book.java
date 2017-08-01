package com.patashala57;

//Represent a Written or printed work consisting of pages.
class Book {

    private final String name;
    private final String author;
    private final int yearPublished;


    Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.yearPublished = year;
    }

    String stringRepresentation() {
        return String.format("%-35s %-35s %-35s", this.name, this.author, this.yearPublished);
    }

    String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Book that = (Book) other;
        return this.name.equals(that.name) && this.author.equals(that.author)
                && this.yearPublished == that.yearPublished;
    }

}

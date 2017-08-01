package com.patashala57;

//Represent a Written or printed work consisting of pages.
class Book {

    private final String name;
    private final String author;
    private final Integer yearPublished;


    Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.yearPublished = year;
    }

    String stringRepresentation() {
        return String.format("%-35s %-35s %-35s", this.name, this.author, this.yearPublished);
    }

}

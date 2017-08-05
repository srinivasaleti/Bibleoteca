package com.patashala57.model;

//Represent a Written or printed work consisting of pages.
public class Book implements LibraryItem {

    private final String name;
    private final String author;
    private final int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String stringRepresentation() {
        return String.format("%-35s %-35s %-35s", this.name, this.author, this.yearPublished);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Book that = (Book) other;
        return this.name.equals(that.name) && this.author.equals(that.author)
                && this.yearPublished == that.yearPublished;
    }

    @Override
    public boolean isSameName(String bookName) {
        return this.name.equalsIgnoreCase(bookName);
    }

}

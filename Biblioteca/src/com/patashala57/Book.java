package com.patashala57;

//Represent a Written or printed work consisting of pages.
class Book {

    private final String name;

    Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

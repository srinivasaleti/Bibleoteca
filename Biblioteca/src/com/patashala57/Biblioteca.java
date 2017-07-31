package com.patashala57;

import java.util.List;

//Represents a room containing collections of books,\
class Biblioteca {

    private final IO io;
    private final List<Book> books;

    Biblioteca(IO io, List<Book> books) {
        this.io = io;
        this.books = books;
    }

    Biblioteca(IO mockIO) {
        this(mockIO, null);
    }

    void printWelcomeMessage() {
        io.display("Welcome To Bangalore Public Library");
    }

    void printBooks() {

        if (books == null || books.size() == 0) {
            io.display("No Books Available\n");
            return;
        }

        StringBuilder result = new StringBuilder(String.format("Books::\n%-35s %-35s %-35s","Name",
                                                                "Author","Year")+"\n\n");

        for (Book book : books) {
            result.append(book.stringRepresentation()).append("\n");
        }

        io.display(result.toString());
    }

}

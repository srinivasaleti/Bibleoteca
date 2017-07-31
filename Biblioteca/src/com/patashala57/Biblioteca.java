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

        StringBuilder result = new StringBuilder(String.format("Books::\n%-35s %-35s %-35s", "Name",
                "Author", "Year") + "\n\n");

        for (Book book : books) {
            result.append(book.stringRepresentation()).append("\n");
        }

        io.display(result.toString());
    }

    void menu() {
        String menu = "Menu::\n1->List Books\n0->Quit\n";
        io.display(menu);
    }
    
    void selectAOptionFromMenu() {
        menu();
        io.display("Select an Option From Menu::");
        String option = io.getInput();
        if (option.equals("1")) {
            this.printBooks();
        }
        if (option.equals("0")) {
            io.display("Quit");
        } else {
            io.display("Invalid Option");
        }
    }

}

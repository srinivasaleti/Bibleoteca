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

    void selectMenu() {
        String menuOption;
        label:
        while (true) {
            menu();
            io.display("Select an Option From Menu::");
            menuOption = io.getInput();
            switch (menuOption) {
                case "1":
                    this.printBooks();
                    break;
                case "0":
                    io.display("Thank you for your valuable time");
                    break label;
                default:
                    io.display("Invalid Option");
                    break;
            }
        }
    }

}

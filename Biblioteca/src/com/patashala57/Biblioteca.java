package com.patashala57;

import java.util.ArrayList;
import java.util.List;

//Represents a room containing collections of books,\
class Biblioteca {

    private final IO io;
    private List<Book> books;

    Biblioteca(IO io, List<Book> books) {
        this.io = io;
        this.books = new ArrayList<>(books);
    }

    Biblioteca(IO io) {
        this(io, new ArrayList<>());
    }

    void printWelcomeMessage() {
        io.println("Welcome To Bangalore Public Library");
    }

    private void printBooks() {
        if (books == null || books.isEmpty()) {
            io.println("No Books Available\n");
            return;
        }

        io.println("Books::");
        String headding = String.format("%-35s %-35s %-35s", "Name",
                "Author", "Year");

        io.println(headding);

        for (Book book : books) {
            io.println(book.stringRepresentation());
        }

    }

    void menu() {
        io.println("Menu::");
        io.println("1->List Books");
        io.println("2->CheckOut a Book");
        io.println("quit to EXIT");
    }

    void selectMenu() {
        String menuOption;
        label:
        while (true) {
            menu();
            io.print("Select an Option From Menu::");
            menuOption = io.getInput();
            menuOption = menuOption.toLowerCase();
            switch (menuOption) {
                case "1":
                    this.printBooks();
                    break;
                case "2":
                    if (books == null || books.isEmpty()) {
                        io.println("No Books Available");
                    }
                    io.print("Enter a Book Name to check Out::");
                    String bookName = io.getInput();
                    this.checkOutABook(bookName);
                    break;
                case "quit":
                    io.println("Thank you for your valuable time");
                    break label;
                default:
                    io.println("Invalid Option");
                    break;
            }
        }
    }

    Book checkOutABook(String bookName) {
        bookName = bookName.toLowerCase();
        Book checkedOut;
        for (Book book : books) {
            if (book.name().toLowerCase().equals(bookName)) {
                checkedOut = book;
                books.remove(book);
                io.print("Thank you! Enjoy the book");
                return checkedOut;
            }
        }
        io.println("That book is not available");
        return null;
    }

}

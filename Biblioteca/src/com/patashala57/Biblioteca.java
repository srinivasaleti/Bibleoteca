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
        io.display("Welcome To Bangalore Public Library");
    }

    private void printBooks() {
        if (books == null || books.isEmpty()) {
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
        String menu = "Menu::\n1->List Books\n2->checkout a book\nquit->Quit\n";
        io.display(menu);
    }

    void selectMenu() {
        String menuOption;
        label:
        while (true) {
            menu();
            io.display("Select an Option From Menu::");
            menuOption = io.getInput();


            menuOption = menuOption.toLowerCase();

            switch (menuOption) {
                case "1":
                    this.printBooks();
                    break;
                case "2":
                    this.checkOutABook();
                    break;
                case "quit":
                    io.display("Thank you for your valuable time");
                    break label;
                default:
                    io.display("Invalid Option");
                    break;
            }
        }
    }

    Book checkOutABook() {
        io.display("Enter a Book Name to check Out::");
        String bookName = io.getInput();
        bookName = bookName.toLowerCase();
        Book checkedOut;
        for (Book book : books) {
            if (book.name().toLowerCase().equals(bookName)) {
                checkedOut=book;
                books.remove(book);
                io.display("Thank you! Enjoy the book");
                return checkedOut;
            }
        }
        io.display("That book is not available");
        return null;
    }

}

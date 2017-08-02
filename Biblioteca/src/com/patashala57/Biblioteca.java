package com.patashala57;

import java.util.ArrayList;
import java.util.List;

//Represents a room containing collections of allBooks
class Biblioteca {

    private final IO io;
    private List<Book> allBooks;
    private List<Book> checkedOutBooks;

    private static final String SUCCESSFUL_RETURN = "Thank you for returning the book";
    private static final String PRINT_MESSAGE = "Welcome To Bangalore Public Library";
    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String THANK_YOU_ENJOY_BOOK = "Thank you! Enjoy the book";
    private static final String MENU = "Menu::";
    private static final String LIST_OPTION = "1->List Books";
    private static final String CHECKOUT_OPTION = "2->CheckOut a Book";
    private static final String RETURN_OPTION = "3->Return a Book";
    private static final String QUIT_OPTION = "quit to EXIT";
    private static final String LIST_BOOKS = "1";
    private static final String CHECKOUT = "2";
    private static final String QUIT = "quit";
    private static final String RETURN_BOOK = "3";
    private static final String THIS_BOOk_NOT_AVAILABLE = "That book is not available";
    private static final String INVALID_OPTION = "Invalid Option";
    private static final String ENTER_BOOK_NAME_TO_CHECK_OUT = "Enter a Book Name to check Out::";
    private static final String THANK_YOU_FOR_YOUR_VALUABLE_TIME = "Thank you for your valuable time";
    private static final String ENTER_RETURN_BOOK_NAME = "Enter Book Name to return::";
    private static final String BOOKS = "Books::";
    private static final String EMPTY_LINE = "";
    private static final String INVALID_BOOK_RETURN = "That is not a valid book to return";

    Biblioteca(IO io, List<Book> books) {
        this.io = io;
        if (books == null) {
            this.allBooks = new ArrayList<>();
        }
        else {
            this.allBooks = new ArrayList<>(books);
        }
        this.checkedOutBooks = new ArrayList<>();
    }

    Biblioteca(IO io) {
        this(io, new ArrayList<>());
    }

    void displayWelcomeMessage() {
        io.println(PRINT_MESSAGE);
    }

    private void displayAllBooks() {
        if (allBooks.isEmpty()) {
            io.println(NO_BOOK_AVAILABLE_MESSAGE);
            return;
        }
        io.println(BOOKS);
        String format = "%-35s %-35s %-35s";
        String headding = String.format(format, "Name", "Author", "Year");
        io.println(headding);
        for (Book book : allBooks) {
            io.println(book.stringRepresentation());
        }
    }

    void menu() {
        //ravi: is it possible to use array and looping through to println
        io.println(EMPTY_LINE);
        io.println(MENU);
        io.println(LIST_OPTION);
        io.println(CHECKOUT_OPTION);
        io.println(RETURN_OPTION);
        io.println(QUIT_OPTION);
        io.println(EMPTY_LINE);
    }

    void selectMenu() {
        String menuOption;
        label:
        while (true) {
            menu();
            menuOption = readInputFromUser();
            //ravi: replace conditionals with polymorphism
            switch (menuOption) {
                case LIST_BOOKS:
                    this.displayAllBooks();
                    break;
                case CHECKOUT:
                    checkOut();
                    break;
                case RETURN_BOOK:
                    returnBook();
                    break;
                case QUIT:
                    io.println(THANK_YOU_FOR_YOUR_VALUABLE_TIME);
                    break label;
                default:
                    io.println(INVALID_OPTION);
                    break;
            }
        }
    }

    private void returnBook() {
        io.print(ENTER_RETURN_BOOK_NAME);
        String bookName = io.getInput();
        this.returnBook(bookName);
    }

    private void checkOut() {
        if (allBooks == null || allBooks.isEmpty()) {
            io.println(NO_BOOK_AVAILABLE_MESSAGE);
        } else {
            io.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
            String bookName = io.getInput();
            this.checkOutABook(bookName);
        }
    }

    private String readInputFromUser() {
        String menuOption;
        io.print("Select an Option From Menu::");
        menuOption = io.getInput();
        menuOption = menuOption.toLowerCase();
        return menuOption;
    }

    private void checkOutABook(String bookName) {
        Book checkOutBook = findBook(this.allBooks, bookName);
        moveBook(checkOutBook, allBooks, checkedOutBooks, THANK_YOU_ENJOY_BOOK, THIS_BOOk_NOT_AVAILABLE);

    }

    private void moveBook(Book checkOutBook, List<Book> fromList, List<Book> checkedOutBooks, String succes, String fail) {
        if (checkOutBook != null) {
            fromList.remove(checkOutBook);
            checkedOutBooks.add(checkOutBook);
            io.println(succes);
        } else {
            io.println(fail);
        }
    }


    private void returnBook(String bookName) {
        Book book = findBook(this.checkedOutBooks, bookName);
        moveBook(book, checkedOutBooks, allBooks, SUCCESSFUL_RETURN, INVALID_BOOK_RETURN);
    }

    private Book findBook(List<Book> booksList, String bookName) {
        Book checkOutBook = null;
        bookName = bookName.toLowerCase();
        for (Book book : booksList) {
            if (book.name().toLowerCase().equals(bookName)) {
                checkOutBook = book;
                break;
            }
        }
        return checkOutBook;
    }

}

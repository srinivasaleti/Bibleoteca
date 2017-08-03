package com.patashala57;

import java.util.ArrayList;
import java.util.List;

//Represents a room containing collections of Things
class Biblioteca {

    private final IO io;
    private List<LibraryItem> allItems;
    private List<LibraryItem> checkedOutItems;

    private static final String SUCCESSFUL_RETURN = "Thank you for returning the book";
    private static final String PRINT_MESSAGE = "Welcome To Bangalore Public Library";
    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String THANK_YOU_ENJOY_BOOK = "Thank you! Enjoy the book";
    private static final String MENU = "Menu::";
    private static final String LIST_OPTION = "1->List Books";
    private static final String CHECKOUT_OPTION = "2->CheckOut a Book";
    private static final String RETURN_OPTION = "3->Return a Book";
    private static final String QUIT_OPTION = "quit to EXIT";
    private static final String THIS_BOOK_NOT_AVAILABLE = "That book is not available";
    private static final String INVALID_OPTION = "Invalid Option";
    private static final String ENTER_BOOK_NAME_TO_CHECK_OUT = "Enter a Book Name to check Out::";
    private static final String THANK_YOU_FOR_YOUR_VALUABLE_TIME = "Thank you for your valuable time";
    private static final String ENTER_RETURN_BOOK_NAME = "Enter Book Name to return::";
    private static final String BOOKS = "Books::";
    private static final String EMPTY_LINE = "";
    private static final String SELECT_MENU_OPTION = "Select an Option From Menu::";
    private static final String INVALID_BOOK_RETURN = "That is not a valid book to return";

    Biblioteca(IO io, List<LibraryItem> items) {
        this.io = io;
        if (items == null) {
            this.allItems = new ArrayList<>();
        } else {
            this.allItems = new ArrayList<>(items);
        }
        this.checkedOutItems = new ArrayList<>();
    }

    Biblioteca(IO io) {
        this(io, new ArrayList<>());
    }

    void launch() {
        displayWelcomeMessage();
        menuSelection();
    }

    private void displayWelcomeMessage() {
        io.println(PRINT_MESSAGE);
    }

    void displayAllItems() {
        if (allItems.isEmpty()) {
            io.println(NO_BOOK_AVAILABLE_MESSAGE);
            return;
        }
        io.println(BOOKS);
        String format = "%-35s %-35s %-35s";
        String headding = String.format(format, "Name", "Author", "Year");
        io.println(headding);
        for (LibraryItem item : allItems) {
            io.println(item.stringRepresentation());
        }
    }

    void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_OPTION, CHECKOUT_OPTION, RETURN_OPTION,
                QUIT_OPTION, EMPTY_LINE};
        for (String option : options) {
            io.println(option);
        }
    }

    private void menuSelection() {
        String menuOption;
        while (true) {
            displayMenu();
            menuOption = readMenuOptionFromUser();
            Command command = CommandFactory.getCommand(menuOption);
            command.execute(this);
            if (command.getClass().equals(QuitCommand.class)) {
                break;
            }
        }
    }

    void quit() {
        io.println(THANK_YOU_FOR_YOUR_VALUABLE_TIME);
    }

    void invalid() {
        io.println(INVALID_OPTION);
    }

    private String readMenuOptionFromUser() {
        String menuOption;
        io.print(SELECT_MENU_OPTION);
        menuOption = io.getInput();
        menuOption = menuOption.toLowerCase();
        return menuOption;
    }

    void checkout() {
        if (allItems.isEmpty()) {
            io.println(NO_BOOK_AVAILABLE_MESSAGE);
        } else {
            io.print(ENTER_BOOK_NAME_TO_CHECK_OUT);
            String bookName = io.getInput();
            this.checkoutABook(bookName);
        }
    }

    private void checkoutABook(String itemName) {
        LibraryItem checkoutItem = findItem(this.allItems, itemName);
        moveBook(checkoutItem, allItems, checkedOutItems);
        displayMessage(THANK_YOU_ENJOY_BOOK,THIS_BOOK_NOT_AVAILABLE,checkoutItem);
    }

    void readInputToReturn() {
        io.print(ENTER_RETURN_BOOK_NAME);
        String bookName = io.getInput();
        this.returnAItem(bookName);
    }

    private void returnAItem(String bookName) {
        LibraryItem book = findItem(this.checkedOutItems, bookName);
        displayMessage(SUCCESSFUL_RETURN, INVALID_BOOK_RETURN,book);
        moveBook(book, checkedOutItems, allItems);
    }

    private LibraryItem findItem(List<LibraryItem> libraryItems, String bookName) {
        LibraryItem itemWithGivenName = null;
        bookName = bookName.toLowerCase();
        for (LibraryItem item : libraryItems) {
            if (item.isSameName(bookName)) {
                itemWithGivenName = item;
                break;
            }
        }
        return itemWithGivenName;
    }

    private void displayMessage(String successMessage, String unSuccessMessage, LibraryItem item) {
        if (item != null) {
            io.println(successMessage);
        } else {
            io.println(unSuccessMessage);
        }
    }

    private void moveBook(LibraryItem item, List<LibraryItem> fromList, List<LibraryItem> toList) {
        if (item != null) {
            fromList.remove(item);
            toList.add(item);
        }
    }

}

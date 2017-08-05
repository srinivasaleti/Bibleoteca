package com.patashala57.controller;

import com.patashala57.view.IO;

//Represents menu For biblioteca
public class Menu {

    private static final String WELCOME_MESSAGE = "Welcome To Bangalore Public Library";
    private static final String MENU = "Menu::";
    private static final String LIST_BOOKS = "1->List Books";
    private static final String CHECKOUT_A_BOOK = "2->CheckOut a Book";
    private static final String RETURN_BOOK_OPTION = "3->Return a Book";
    private static final String LIST_MOVIES = "4->List Movies";
    private static final String CHECKOUT_MOVIE = "5->Checkout Movie";
    private static final String RETURN_MOVIE = "6->Return Movie";
    private static final String QUIT = "quit to EXIT";
    private static final String EMPTY_LINE = "";
    private static final String SELECT_OPTION = "Select an Option From Menu::";

    private final IO consoleIO;
    private final Factory commandFactory;

    public Menu(Factory commandFactory, IO consoleIO) {
        this.consoleIO = consoleIO;
        this.commandFactory = commandFactory;
    }

    void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_BOOKS, CHECKOUT_A_BOOK,
                RETURN_BOOK_OPTION, LIST_MOVIES, CHECKOUT_MOVIE, RETURN_MOVIE,
                QUIT, EMPTY_LINE};
        for (String option : options) {
            this.consoleIO.println(option);
        }
    }

    private void menuSelection() {
        String menuOption;
        Command command;
        boolean isQuit = false;
        while (!isQuit) {
            this.displayMenu();
            menuOption = this.readMenuOptionFromUser();
            menuOption = menuOption.toLowerCase();
            command = commandFactory.getCommand(menuOption);
            command.execute();
            if (command.getClass().equals(QuitCommand.class)) {
                isQuit = true;
            }
        }
    }

    String readMenuOptionFromUser() {
        this.consoleIO.print(SELECT_OPTION);
        return this.consoleIO.getInput();
    }

    public void launch() {
        this.displayWelcomeMessage();
        this.menuSelection();
    }

    private void displayWelcomeMessage() {
        consoleIO.println(WELCOME_MESSAGE);
    }

}

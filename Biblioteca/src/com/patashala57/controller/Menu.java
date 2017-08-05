package com.patashala57.controller;

import com.patashala57.view.Command;
import com.patashala57.view.IO;
import com.patashala57.view.QuitCommand;

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

    private IO io;
    private Factory commandFactory;

    public Menu(Factory commandFactory, IO io) {
        this.io = io;
        this.commandFactory = commandFactory;
    }

    public void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_BOOKS, CHECKOUT_A_BOOK,
                RETURN_BOOK_OPTION, LIST_MOVIES, CHECKOUT_MOVIE, RETURN_MOVIE,
                QUIT, EMPTY_LINE};
        for (String option : options) {
            io.println(option);
        }
    }

    private void menuSelection() {
        String menuOption;
        Command command;
        while (true) {
            displayMenu();
            menuOption = readMenuOptionFromUser();
            menuOption = menuOption.toLowerCase();
            command = commandFactory.getCommand(menuOption);
            command.execute();
            if (command.getClass().equals(QuitCommand.class)) {
                break;
            }
        }
    }

    public String readMenuOptionFromUser() {
        io.print(SELECT_OPTION);
        return io.getInput();
    }

    public void launch() {
        displayWelcomeMessage();
        menuSelection();
    }

    private void displayWelcomeMessage() {
        io.println(WELCOME_MESSAGE);
    }

}

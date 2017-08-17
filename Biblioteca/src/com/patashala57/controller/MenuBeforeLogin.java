package com.patashala57.controller;

import com.patashala57.view.IO;

//Represents menu For biblioteca if user has login
public class MenuBeforeLogin implements Menu {

    private static final String WELCOME_MESSAGE = "Welcome To Bangalore Public Library";
    private static final String MENU = "Menu::";
    private static final String LIST_BOOKS = "1->List Books";
    private static final String LIST_MOVIES = "2->List Movies";
    private static final String LOGIN = "3->Login";
    private static final String QUIT = "Type quit to EXIT from biblioteca";
    private static final String EMPTY_LINE = "";
    private static final String SELECT_OPTION = "Select an Option From Menu::";

    private final IO consoleIO;
    private final Factory commandFactory;

    public MenuBeforeLogin(Factory commandFactory, IO consoleIO) {
        this.consoleIO = consoleIO;
        this.commandFactory = commandFactory;
    }

    private void menuSelection() {
        String menuOption;
        Command command;
        do {
            this.displayMenu();
            menuOption = this.readMenuOptionFromUser();
            menuOption = menuOption.toLowerCase();
            command = commandFactory.getCommand(menuOption);
            command.execute();
        } while (!command.getClass().equals(QuitCommand.class));
    }

    public void launch() {
        this.displayWelcomeMessage();
        this.menuSelection();
    }

    private String readMenuOptionFromUser() {
        this.consoleIO.print(SELECT_OPTION);
        return this.consoleIO.getInput();
    }

    private void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_BOOKS, LIST_MOVIES, LOGIN,
                QUIT, EMPTY_LINE};
        for (String option : options) {
            this.consoleIO.println(option);
        }
    }

    private void displayWelcomeMessage() {
        consoleIO.println(WELCOME_MESSAGE);
    }

}

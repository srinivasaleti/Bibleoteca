package com.patashala57;

class Menu {

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
    private CommandFactory commandFactory;

    Menu(CommandFactory commandFactory, IO io) {
        this.io = io;
        this.commandFactory = commandFactory;
    }

    void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_BOOKS, CHECKOUT_A_BOOK,
                RETURN_BOOK_OPTION, LIST_MOVIES, CHECKOUT_MOVIE, RETURN_MOVIE,
                QUIT, EMPTY_LINE};
        for (String option : options) {
            io.println(option);
        }
    }

    void menuSelection() {
        String menuOption;
        while (true) {
            displayMenu();
            menuOption = readMenuOptionFromUser();
            menuOption = menuOption.toLowerCase();
            Command command = commandFactory.getCommand(menuOption);
            command.execute();
            if (command.getClass().equals(QuitCommand.class)) {
                break;
            }
        }
    }

    String readMenuOptionFromUser() {
        io.print(SELECT_OPTION);
        return io.getInput();
    }

    void launch() {
        displayWelcomeMessage();
        menuSelection();
    }

    private void displayWelcomeMessage() {
        io.println(WELCOME_MESSAGE);
    }

}

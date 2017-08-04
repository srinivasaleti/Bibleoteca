package com.patashala57;

class Menu {

    private static final String PRINT_MESSAGE = "Welcome To Bangalore Public Library";
    private static final String MENU = "Menu::";
    private static final String LIST_OPTION = "1->List Books";
    private static final String CHECKOUT_BOOK_OPTION = "2->CheckOut a Book";
    private static final String RETURN_BOOK_OPTION = "3->Return a Book";
    private static final String LIST_MOVIES = "4->List Movies";
    private static final String CHECKOUT_MOVIES = "5->Checkout Movie";
    private static final String RETURN_MOVIES = "6->Return Movie";
    private static final String QUIT_OPTION = "quit to EXIT";
    private static final String EMPTY_LINE = "";
    private static final String SELECT_MENU_OPTION = "Select an Option From Menu::";

    private Biblioteca biblioteca;
    private IO io;
    private CommandFactory commandFactory;

    Menu(Biblioteca biblioteca, IO io) {
        this.biblioteca = biblioteca;
        this.io = io;
        this.commandFactory=new CommandFactory(biblioteca,io);
    }

    void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_OPTION, CHECKOUT_BOOK_OPTION, RETURN_BOOK_OPTION,
                LIST_MOVIES, CHECKOUT_MOVIES, RETURN_MOVIES , QUIT_OPTION, EMPTY_LINE};
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
        io.print(SELECT_MENU_OPTION);
        return io.getInput();
    }

    void launch(){
        displayWelcomeMessage();
        menuSelection();
    }

    private void displayWelcomeMessage()
    {
        io.println(PRINT_MESSAGE);
    }

}

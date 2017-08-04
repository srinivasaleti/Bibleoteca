package com.patashala57;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Represents a room containing collections of Things
class Biblioteca {

    private final IO io;
    private List<LibraryItem> allItems;
    private List<LibraryItem> checkedOutItems;
    private CommandFactory commandFactory;

    private static final String PRINT_MESSAGE = "Welcome To Bangalore Public Library";
    private static final String MENU = "Menu::";
    private static final String LIST_OPTION = "1->List Books";
    private static final String CHECKOUT_BOOK_OPTION = "2->CheckOut a Book";
    private static final String RETURN_BOOK_OPTION = "3->Return a Book";
    private static final String LIST_MOVIES = "4->List Movies";
    private static final String CHECKOUT_MOVIES = "5->Checkout Movie";
    private static final String QUIT_OPTION = "quit to EXIT";
    private static final String EMPTY_LINE = "";
    private static final String SELECT_MENU_OPTION = "Select an Option From Menu::";

    Biblioteca(IO io, List<LibraryItem> items) {
        this.io = io;
        if (items == null) {
            this.allItems = new ArrayList<>();
        } else {
            this.allItems = new ArrayList<>(items);
        }
        this.checkedOutItems = new ArrayList<>();
        this.commandFactory = new CommandFactory(this, this.io);
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

    void displayItems(Class<? extends LibraryItem> className) {
        List<LibraryItem> items=getList(className);
        for (LibraryItem item : items) {
            io.println(item.stringRepresentation());
        }
    }

    private List<LibraryItem> getList(Class<? extends LibraryItem> className){
        return this.allItems.stream()
                .filter(x->x.getClass()==className)
                .collect(Collectors.toList());
    }

    void displayMenu() {
        String options[] = {EMPTY_LINE, MENU, LIST_OPTION, CHECKOUT_BOOK_OPTION, RETURN_BOOK_OPTION,
                LIST_MOVIES, CHECKOUT_MOVIES, QUIT_OPTION, EMPTY_LINE};
        for (String option : options) {
            io.println(option);
        }
    }

    private void menuSelection() {
        String menuOption;
        while (true) {
            displayMenu();
            menuOption = readMenuOptionFromUser();
            Command command = commandFactory.getCommand(menuOption);
            command.execute();
            if (command.getClass().equals(QuitCommand.class)) {
                break;
            }
        }
    }

    private String readMenuOptionFromUser() {
        String menuOption;
        io.print(SELECT_MENU_OPTION);
        menuOption = io.getInput();
        menuOption = menuOption.toLowerCase();
        return menuOption;
    }

    LibraryItem checkoutItem(Class<? extends LibraryItem> itemClass, String itemName) {
        LibraryItem itemWithGivenName = findItem(itemClass, this.allItems, itemName);
        if (itemWithGivenName == null){
            return null;
        }
        moveItem(itemWithGivenName, allItems, checkedOutItems);
        return itemWithGivenName;
    }

    boolean returnItem(Class itemClass, String itemName) {
        LibraryItem item = findItem(itemClass, this.checkedOutItems, itemName);
        moveItem(item, checkedOutItems, allItems);
        return item != null;
    }

    private LibraryItem findItem(Class<? extends LibraryItem> itemClass, List<LibraryItem> list,
                                 String itemName) {
        Optional<LibraryItem> item = list
                .stream()
                .filter(x -> x.getClass().equals(itemClass))
                .filter(y -> y.isSameName(itemName))
                .findFirst();
        return item.orElse(null);
    }

    private void moveItem(LibraryItem item, List<LibraryItem> fromList, List<LibraryItem> toList) {
        if (item != null) {
            fromList.remove(item);
            toList.add(item);
        }
    }

    private List<LibraryItem> filterItems(Class aClass) {
        return this.allItems.stream()
                .filter(x -> x.getClass()
                        .equals(aClass))
                .collect(Collectors.toList());
    }

    boolean isNoItemsAvailable(Class itemClass){
        return this.filterItems(itemClass).isEmpty();
    }

}

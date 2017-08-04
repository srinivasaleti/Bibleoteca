package com.patashala57;

import com.sun.org.apache.bcel.internal.generic.RETURN;

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

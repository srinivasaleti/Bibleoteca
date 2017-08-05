package com.patashala57.model;

import com.patashala57.view.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Represents a room containing collections of items
public class Biblioteca implements Library {

    private final List<LibraryItem> allItems;
    private final List<LibraryItem> checkedOutItems;

    public Biblioteca(List<LibraryItem> items) {
        if (items == null) {
            this.allItems = new ArrayList<>();
        } else {
            this.allItems = new ArrayList<>(items);
        }
        this.checkedOutItems = new ArrayList<>();
    }

    @Override
    public String stringRepresentationOfItems(Class<? extends LibraryItem> className) {
        StringBuilder result = new StringBuilder();
        List<LibraryItem> items = filterRequiredItemsInAList(this.allItems, className);
        for (LibraryItem item : items) {
            result.append(item.stringRepresentation()).append(IO.LINE_SEPARATOR);
        }
        return result.toString();
    }

    @Override
    public Optional<LibraryItem> checkoutItem(Class<? extends LibraryItem> itemClass,
                                              String itemName) {
        Optional<LibraryItem> itemWithGivenName = findItem(itemClass, this.allItems, itemName);
        itemWithGivenName.ifPresent(libraryItem -> moveItem(libraryItem, this.allItems,
                this.checkedOutItems));
        return itemWithGivenName;
    }

    @Override
    public boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName) {
        Optional<LibraryItem> item = findItem(itemClass, this.checkedOutItems, itemName);
        if (!item.isPresent()) {
            return false;
        }
        moveItem(item.get(), this.checkedOutItems, this.allItems);
        return true;
    }

    @Override
    public boolean isNoItemsAvailable(Class<? extends LibraryItem> itemClass) {
        return this.filterRequiredItemsInAList(this.allItems, itemClass).isEmpty();
    }

    private Optional<LibraryItem> findItem(Class<? extends LibraryItem> itemClass,
                                           List<LibraryItem> list,
                                           String itemName) {
        return this.filterRequiredItemsInAList(list, itemClass)
                .stream()
                .filter(y -> y.isSameName(itemName))
                .findFirst();
    }

    private List<LibraryItem> filterRequiredItemsInAList(List<LibraryItem> items,
                                                         Class<? extends LibraryItem> className) {
        return items.stream()
                .filter(x -> x.getClass() == className)
                .collect(Collectors.toList());
    }

    private void moveItem(LibraryItem item, List<LibraryItem> fromList, List<LibraryItem> toList) {
        if (item != null) {
            fromList.remove(item);
            toList.add(item);
        }
    }

}

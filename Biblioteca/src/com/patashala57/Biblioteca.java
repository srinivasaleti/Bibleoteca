package com.patashala57;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Represents a room containing collections of items
class Biblioteca {

    private List<LibraryItem> allItems;
    private List<LibraryItem> checkedOutItems;

    Biblioteca(List<LibraryItem> items) {
        if (items == null) {
            this.allItems = new ArrayList<>();
        } else {
            this.allItems = new ArrayList<>(items);
        }
        this.checkedOutItems = new ArrayList<>();
    }

    String stringRepresentationOfItems(Class<? extends LibraryItem> className) {
        StringBuilder result = new StringBuilder();
        List<LibraryItem> items = filterRequiredItemsInAList(this.allItems, className);
        for (LibraryItem item : items) {
            result.append(item.stringRepresentation()).append(System.lineSeparator());
        }
        return result.toString();
    }

    LibraryItem checkoutItem(Class<? extends LibraryItem> itemClass, String itemName) {
        LibraryItem itemWithGivenName = findItem(itemClass, this.allItems, itemName);
        if (itemWithGivenName == null) {
            return null;
        }
        moveItem(itemWithGivenName, allItems, checkedOutItems);
        return itemWithGivenName;
    }

    boolean isNoItemsAvailable(Class<? extends LibraryItem> itemClass) {
        return this.filterRequiredItemsInAList(this.allItems, itemClass).isEmpty();
    }


    boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName) {
        LibraryItem item = findItem(itemClass, this.checkedOutItems, itemName);
        moveItem(item, checkedOutItems, allItems);
        return item != null;
    }

    private LibraryItem findItem(Class<? extends LibraryItem> itemClass,
                                 List<LibraryItem> list,
                                 String itemName) {
        Optional<LibraryItem> item = filterRequiredItemsInAList(list, itemClass)
                .stream()
                .filter(y -> y.isSameName(itemName))
                .findFirst();
        return item.orElse(null);
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

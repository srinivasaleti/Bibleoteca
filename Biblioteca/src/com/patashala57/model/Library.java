package com.patashala57.model;

import java.util.Optional;

//Represents a room containing collection of items
public interface Library {

    String stringRepresentationOfItems(Class<? extends LibraryItem> className);

    Optional<LibraryItem> checkoutItem(Class<? extends LibraryItem> itemClass, String itemName);

    boolean isEmpty(Class<? extends LibraryItem> itemClass);

    boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName);

}

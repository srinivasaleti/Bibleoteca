package com.patashala57.model;

import java.util.Optional;

//Represents a room containing collection of items
public interface Library {

    String stringRepresentationOfItems(Class<? extends LibraryItem> className);

    boolean isEmpty(Class<? extends LibraryItem> itemClass);

    boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName);

    Optional<User> isValidUserCredentials(String validLibraryNo, String validPassword);

    Optional checkoutItem(Class<? extends LibraryItem> itemClass, String bookName, User currentUser);

    void addDetailsToCheckOutRegister(LibraryItem item, User currentUser);
}

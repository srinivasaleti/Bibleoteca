package com.patashala57.model;

import java.util.Optional;

public interface Library {

    String stringRepresentationOfItems(Class<? extends LibraryItem> className);

    Optional<LibraryItem> checkoutItem(Class<? extends LibraryItem> itemClass, String itemName);

    boolean isNoItemsAvailable(Class<? extends LibraryItem> itemClass);

    boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName);

}

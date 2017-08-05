package com.patashala57;

import java.util.Optional;

interface Library {

    String stringRepresentationOfItems(Class<? extends LibraryItem> className);

    Optional<LibraryItem> checkoutItem(Class<? extends LibraryItem> itemClass, String itemName);

    boolean isNoItemsAvailable(Class<? extends LibraryItem> itemClass);

    boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName);

}

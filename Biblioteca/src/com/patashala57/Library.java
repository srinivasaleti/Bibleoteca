package com.patashala57;

interface Library {

    String stringRepresentationOfItems(Class<? extends LibraryItem> className);

    LibraryItem checkoutItem(Class<? extends LibraryItem> itemClass, String itemName);

    boolean isNoItemsAvailable(Class<? extends LibraryItem> itemClass);

    boolean returnItem(Class<? extends LibraryItem> itemClass, String itemName);

}

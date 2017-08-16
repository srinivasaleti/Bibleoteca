package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.LibraryItem;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible form listing all items in library
class ListItems {

    private final Library library;
    private final IO consoleIO;

    ListItems(Library library, IO io) {
        this.library = library;
        this.consoleIO = io;
    }

    void listAll(Class<? extends LibraryItem> itemClass) {
        if (this.library.isEmpty(itemClass)) {
            displayNoItemsAvailable(itemClass);
            return;
        }
        displayItemType(itemClass);
        displayHeader(itemClass);
        this.consoleIO.println(library.stringRepresentationOfItems(itemClass));
    }

    private void displayNoItemsAvailable(Class<? extends LibraryItem> itemClass) {
        if(itemClass==Book.class){
            consoleIO.println("No Books Available");
        }
        if(itemClass==Movie.class){
            consoleIO.println("No Movies Available");
        }
    }

    private void displayItemType(Class<? extends LibraryItem> itemClass){
        if(itemClass==Book.class){
            consoleIO.println("Books::");
        }
        if (itemClass==Movie.class){
            consoleIO.println("Movies::");
        }
    }

    private void displayHeader(Class<? extends LibraryItem> itemClass) {
        if (itemClass == Book.class) {
            String format = "%-35s %-35s %-35s";
            String name = "Name";
            String author = "Author";
            String year = "Year Published";
            consoleIO.println(String.format(format, name, author, year));
        }

        if (itemClass == Movie.class) {
            String format = "%-35s %-35s %-35s %-35s";
            String name = "Name";
            String director = "Director";
            String rating = "Rating";
            String year = "Year";
            consoleIO.println(String.format(format, name, director, rating, year));
        }
    }

}

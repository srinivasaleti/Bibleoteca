package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.view.IO;

//Responsible for listBooks in bibiloteca
public class ListBooksCommand extends ListItems implements Command {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String BOOKS = "Books::";

    ListBooksCommand(Library library, IO io) {
        super(library,io);
    }

    @Override
    public void execute() {
        String format = "%-35s %-35s %-35s";
        String name = "Name";
        String author = "Author";
        String year = "Year Published";
        String header = String.format(format, name, author, year);
        super.listAll(Book.class,NO_BOOK_AVAILABLE_MESSAGE,BOOKS,header);
    }

}

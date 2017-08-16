package com.patashala57.controller;

import com.patashala57.model.Book;
import com.patashala57.model.Library;
import com.patashala57.model.Movie;
import com.patashala57.view.IO;

//Responsible for listBooks in bibiloteca
public class ListBooksCommand extends ListItems implements Command {

    ListBooksCommand(Library library, IO io) {
        super(library,io);
    }

    @Override
    public void execute() {
        super.listAll(Book.class);
    }

}

package com.patashala57;

//Responsible for listBooks in bibiloteca
class ListBooksCommand implements Command {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String BOOKS = "Books::";

    private Library library;
    private IO consoleIO;
    ListBooksCommand(Library library, IO io) {
        this.library = library;
        this.consoleIO =io;
    }

    @Override
    public void execute() {
        if (library.isNoItemsAvailable(Book.class)) {
            consoleIO.println(NO_BOOK_AVAILABLE_MESSAGE);
            return;
        }

        consoleIO.println(BOOKS);
        String format = "%-35s %-35s %-35s";
        String name = "Name";
        String author = "Author";
        String year = "Year Published";
        String header = String.format(format, name, author, year);
        consoleIO.println(header);
        consoleIO.println(library.stringRepresentationOfItems(Book.class));
    }

}

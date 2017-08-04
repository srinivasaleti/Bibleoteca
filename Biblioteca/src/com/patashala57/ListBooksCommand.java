package com.patashala57;

//Responsible for listBooks in bibiloteca
class ListBooksCommand implements Command {

    private static final String NO_BOOK_AVAILABLE_MESSAGE = "No Books Available";
    private static final String BOOKS = "Books::";

    private Biblioteca biblioteca;
    private IO consoleIO;
    ListBooksCommand(Biblioteca biblioteca, IO io) {
        this.biblioteca=biblioteca;
        this.consoleIO =io;
    }

    @Override
    public void execute() {
        if (biblioteca.isNoItemsAvailable(Book.class)) {
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
        consoleIO.println(biblioteca.stringRepresentationOfItems(Book.class));
    }

}

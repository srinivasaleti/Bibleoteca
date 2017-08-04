package com.patashala57;

//Responsible for list moveis in biblioteca
class ListMoviesCommand implements Command {

    private static final String NO_MOVIES_AVAILABLE_MESSAGE = "No Movies Available";
    private static final String MOVIES = "Movies::";

    private Biblioteca biblioteca;
    private IO consoleIO;

    ListMoviesCommand(Biblioteca biblioteca, IO consoleIO) {
        this.biblioteca=biblioteca;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        if(biblioteca.isNoItemsAvailable(Movie.class)){
            consoleIO.println(NO_MOVIES_AVAILABLE_MESSAGE);
            return;
        }
        consoleIO.println(MOVIES);
        String format = "%-35s %-35s %-35s %-35s";
        String name = "Name";
        String director = "Director";
        String rating = "Rating";
        String year = "Year";
        String header = String.format(format, name, director, rating, year);
        consoleIO.println(header);
        consoleIO.println(biblioteca.stringRepresentationOfItems(Movie.class));
    }

}

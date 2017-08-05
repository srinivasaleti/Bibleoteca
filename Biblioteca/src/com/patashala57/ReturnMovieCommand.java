package com.patashala57;

class ReturnMovieCommand implements Command{

    private static final String ENTER_MOVIE_NAME = "Enter Movie Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the Movie";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid Movie to return";

    private Library library;
    private IO consoleIO;

    ReturnMovieCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        consoleIO.print(ENTER_MOVIE_NAME);
        String movieName = consoleIO.getInput();
        boolean isReturn= library.returnItem(Movie.class,movieName);
        displayMessage(isReturn);
    }

    private void displayMessage(boolean isReturn) {
        if (isReturn) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}

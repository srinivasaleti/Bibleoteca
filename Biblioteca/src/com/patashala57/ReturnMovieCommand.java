package com.patashala57;

class ReturnMovieCommand implements Command{

    private static final String ENTER_MOVIE_NAME = "Enter Movie Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the Movie";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid Movie to return";

    private Biblioteca biblioteca;
    private IO consoleIO;

    ReturnMovieCommand(Biblioteca biblioteca, IO consoleIO) {
        this.biblioteca=biblioteca;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        consoleIO.print(ENTER_MOVIE_NAME);
        String movieName = consoleIO.getInput();
        boolean isReturn=biblioteca.returnItem(Movie.class,movieName);
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

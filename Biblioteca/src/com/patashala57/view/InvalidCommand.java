package com.patashala57.view;

//Represetns a Invalid Command to bibiloteca
public class InvalidCommand implements Command {

    private static final String INVALID_OPTION = "Invalid Option";

    private IO io;

    public InvalidCommand(IO io) {
        this.io = io;
    }

    @Override
    public void execute() {
        io.println(INVALID_OPTION);
    }

}

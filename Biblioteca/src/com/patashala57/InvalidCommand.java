package com.patashala57;

//Represetns a Invalid Command to bibiloteca
class InvalidCommand implements Command {

    private static final String INVALID_OPTION = "Invalid Option";

    private IO io;

    InvalidCommand(IO io) {
        this.io = io;
    }

    @Override
    public void execute() {
        io.println(INVALID_OPTION);
    }

}

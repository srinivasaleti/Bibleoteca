package com.patashala57.controller;

import com.patashala57.view.IO;

//Represents Invalid Command to bibiloteca
public class InvalidCommand implements Command {

    private static final String INVALID_OPTION = "Invalid Option";

    private IO consoleIO;

    InvalidCommand(IO consoleIO) {
        this.consoleIO = consoleIO;
    }

    @Override
    public void execute() {
        this.consoleIO.println(INVALID_OPTION);
    }

}

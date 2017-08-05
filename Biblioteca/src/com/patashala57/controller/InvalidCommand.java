package com.patashala57.controller;

import com.patashala57.view.IO;

//Represents Invalid Command to bibiloteca
public class InvalidCommand implements Command {

    private static final String INVALID_OPTION = "Invalid Option";

    private IO io;

    InvalidCommand(IO io) {
        this.io = io;
    }

    @Override
    public void execute() {
        this.io.println(INVALID_OPTION);
    }

}

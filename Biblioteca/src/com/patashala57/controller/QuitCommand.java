package com.patashala57.controller;

import com.patashala57.view.IO;

//Represents quit the application
public class QuitCommand implements Command {

    private static final String THANKS_FOR_YOUR_VALUABLE_TIME = "Thank you for your valuable time";

    private final IO io;

    QuitCommand(IO io) {
        this.io = io;
    }

    @Override
    public void execute() {
        io.println(THANKS_FOR_YOUR_VALUABLE_TIME);
    }

}

package com.patashala57.view;

//Represents quit the application
public class QuitCommand implements Command {

    private static final String THANKS_FOR_YOUR_VALUABLE_TIME = "Thank you for your valuable time";

    private IO io;

    public QuitCommand(IO io) {
        this.io = io;
    }

    @Override
    public void execute() {
        io.println(THANKS_FOR_YOUR_VALUABLE_TIME);
    }

}

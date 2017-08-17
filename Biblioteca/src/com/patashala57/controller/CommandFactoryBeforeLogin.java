package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.view.IO;

//Represents CommandFactory before user login
public class CommandFactoryBeforeLogin implements Factory {

    private final Library library;
    private final IO io;

    public CommandFactoryBeforeLogin(Library library, IO consoleIO) {
        this.library = library;
        this.io = consoleIO;
    }

    @Override
    public Command getCommand(String commandString) {
        if (commandString.equalsIgnoreCase("1")) {
            return new ListBooksCommand(library, io);
        }
        if (commandString.equalsIgnoreCase("2")) {
            return new ListMoviesCommand(library, io);
        }
        if (commandString.equalsIgnoreCase("3")) {
            Factory commandFactory = new CommandFactoryAfterLogin(this.library, this.io);
            MenuAfterLogin menuAfterLogin = new MenuAfterLogin(commandFactory, this.io);
            return new Login(library, io, menuAfterLogin);
        }
        if (commandString.equalsIgnoreCase("quit")) {
            return new QuitCommand(io);
        }
        return new InvalidCommand(io);
    }

}

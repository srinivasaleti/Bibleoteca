package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.model.User;
import com.patashala57.view.IO;

import java.util.Optional;

//Responsible for user login to access bibiloteca
class Login implements Command {

    private static final String ENTER_LIBRARY_NUMBER = "Enter libraryNo::";
    private static final String ENTER_PASSWORD = "Enter password::";
    private static final String INVALID_CREDENTIALS = "Invalid Credentials";

    private final Library library;
    private final IO consoleIO;

    Login(Library library, IO io) {
        this.library = library;
        this.consoleIO = io;
    }

    @Override
    public void execute() {
        this.consoleIO.print(ENTER_LIBRARY_NUMBER);
        String libraryNo = this.consoleIO.getInput();
        this.consoleIO.print(ENTER_PASSWORD);
        String password = this.consoleIO.getInput();
        Optional<User> currentLibraryUser = this.library.isValidUserCredentials(libraryNo, password);
        if (currentLibraryUser.isPresent()) {
            Factory commandFactory = new CommandFactoryAfterLogin(this.library, this.consoleIO);
            MenuAfterLogin menuAfterLogin = new MenuAfterLogin(commandFactory, this.consoleIO,currentLibraryUser.get());
            menuAfterLogin.launch();
            return;
        }
        this.consoleIO.println(INVALID_CREDENTIALS);
    }

}

package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.view.IO;

//Responsible for user login to access bibiloteca
class Login implements Command {

    private static final String ENTER_LIBRARY_NUMBER = "Enter libraryNo::";
    private static final String ENTER_PASSWORD = "Enter password::";
    private static final String INVALID_CREDENTIALS = "Invalid Credentials";

    private final Library library;
    private final IO consoleIO;
    private final Menu menuAfterLogin;

    Login(Library library, IO io, Menu menu) {
        this.library = library;
        this.consoleIO = io;
        this.menuAfterLogin = menu;
    }

    @Override
    public void execute() {
        this.consoleIO.print(ENTER_LIBRARY_NUMBER);
        String libraryNo = this.consoleIO.getInput();
        this.consoleIO.print(ENTER_PASSWORD);
        String password = this.consoleIO.getInput();
        if (this.library.isValidUserCredentials(libraryNo, password)) {
            this.menuAfterLogin.launch();
            return;
        }
        this.consoleIO.println(INVALID_CREDENTIALS);
    }

}
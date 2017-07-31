package com.patashala57;

//Represents a room containing collections of books,\
class Biblioteca {

    private final IO io;

    Biblioteca(IO io) {
        this.io = io;
        printWelcomeMessage();
    }

    private void printWelcomeMessage() {
        io.display("Welcome To Bangalore Public Library");
    }

}

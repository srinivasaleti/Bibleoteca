package com.patashala57;

//Represetns a Invalid Command to bibiloteca
class InvalidCommand implements Command {

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.invalid();
    }

}

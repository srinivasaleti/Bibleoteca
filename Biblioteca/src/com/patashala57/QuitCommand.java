package com.patashala57;

//Represents quit Command for bibiloteca
class QuitCommand implements Command {

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.quit();
    }

}

package com.patashala57;

class ListMoviesCommand implements Command {

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.displayAllItems();
    }

}

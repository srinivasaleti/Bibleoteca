package com.patashala57;

//Represents listBooks Command for bibiloteca
class ListBooksCommand implements Command{

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.displayAllItems();
    }
}

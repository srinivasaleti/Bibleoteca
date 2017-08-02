package com.patashala57;

//Represents ReturnBook Command for bibiloteca
class ReturnBookCommand implements Command{

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.returnBook();
    }

}

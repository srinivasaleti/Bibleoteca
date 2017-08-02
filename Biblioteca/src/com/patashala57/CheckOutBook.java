package com.patashala57;

class CheckOutBook implements Command{

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.checkOut();
    }

}

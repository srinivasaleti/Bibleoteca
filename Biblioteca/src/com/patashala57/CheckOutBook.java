package com.patashala57;

public class CheckOutBook implements Command{

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.checkOut();
    }

}

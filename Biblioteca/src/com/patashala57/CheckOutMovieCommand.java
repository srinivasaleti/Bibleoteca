package com.patashala57;

class CheckOutMovieCommand implements Command{

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.checkout();
    }

}
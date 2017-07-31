package com.patashala57;

import java.io.PrintStream;

class ConsoleIO implements IO {

    private PrintStream out;

    ConsoleIO(PrintStream out) {
        this.out = out;
    }

    @Override
    public void display(String message) {
        out.println(message);
    }

}

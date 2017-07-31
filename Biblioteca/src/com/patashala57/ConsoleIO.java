package com.patashala57;

import java.io.PrintStream;
import java.util.Scanner;

//Responsible for print something on given stream
class ConsoleIO implements IO {

    private PrintStream out;

    ConsoleIO(PrintStream out) {
        this.out = out;
    }

    @Override
    public void display(String message) {
        out.println(message);
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

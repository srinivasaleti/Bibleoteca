package com.patashala57;

import java.io.PrintStream;
import java.util.Scanner;

//Responsible for print something on given stream
class ConsoleIO implements IO {

    private PrintStream out;
    private Scanner scanner;

    ConsoleIO(PrintStream out, Scanner scanner) {
        this.out = out;
        this.scanner = scanner;
    }

    @Override
    public void display(String message) {
        out.println(message);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

}

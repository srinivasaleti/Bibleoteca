package com.patashala57.view;

import java.io.PrintStream;
import java.util.Scanner;

//Responsible for print something on given stream
public class ConsoleIO implements IO {

    private final PrintStream out;
    private final Scanner scanner;

    public ConsoleIO(PrintStream out, Scanner scanner) {
        this.out = out;
        this.scanner = scanner;
    }

    @Override
    public void println(String message) {
        out.println(message);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void print(String message) {
        out.print(message);
    }

}

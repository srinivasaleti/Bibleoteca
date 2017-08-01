package com.patashala57;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ConsoleIOTest {

    @Test
    void displayHello() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);

        console.println("Hello");
        verify(out).println("Hello");
    }

    @Test
    void displayWorld() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);

        console.println("Hello");
        verify(out).println("Hello");
    }

    @Test
    void displayHi() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);

        console.print("Srinu");
        verify(out).print("Srinu");
    }

}

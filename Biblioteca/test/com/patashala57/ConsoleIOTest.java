package com.patashala57;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ConsoleIOTest {

    @Test
    void printHello() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);

        console.display("Hello");
        verify(out).println("Hello");
    }

    @Test
    void printWorld() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);

        console.display("Hello");
        verify(out).println("Hello");
    }

}

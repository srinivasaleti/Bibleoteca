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
        String hello = "Hello";

        console.println(hello);

        verify(out).println(hello);
    }

    @Test
    void displayWorld() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);
        String world = "World";

        console.println(world);
        verify(out).println(world);
    }

    @Test
    void displayHi() {
        PrintStream out = mock(System.out.getClass());
        Scanner scanner = new Scanner(System.in);
        ConsoleIO console = new ConsoleIO(out, scanner);
        String hi = "hi";

        console.print(hi);
        verify(out).print(hi);
    }

}

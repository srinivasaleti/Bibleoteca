package com.patashala57;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Responsible for executing Biblioteca
class Runner {

    private static List<LibraryItem> generateBooks() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        return Arrays.asList(halfGirlFriend, loveStory, firstLove);
    }

    public static void main(String args[]) {
        ConsoleIO consoleIO = new ConsoleIO(System.out, new Scanner(System.in));
        Biblioteca biblioteca = new Biblioteca(consoleIO, generateBooks());
        biblioteca.launch();
    }

}

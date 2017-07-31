package com.patashala57;

import java.util.Arrays;
import java.util.List;

//Responsible for executing Biblioteca
class MainClass {

    static List<Book> listOfBooks() {
        Book halfGirlFriend = new Book("Half GirlFriend");
        Book loveStory = new Book("Love Story");
        Book firstLove = new Book("First Love");
        List<Book> books = Arrays.asList(halfGirlFriend, loveStory, firstLove);

        return books;
    }

    public static void main(String args[]) {
        IO consoleIO = new ConsoleIO(System.out);

        Biblioteca library = new Biblioteca(consoleIO, listOfBooks());

        library.printBooks();
    }

}

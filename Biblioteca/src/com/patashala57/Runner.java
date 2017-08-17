package com.patashala57;

import com.patashala57.controller.CommandFactoryBeforeLogin;
import com.patashala57.controller.Factory;
import com.patashala57.controller.MenuBeforeLogin;
import com.patashala57.model.*;
import com.patashala57.view.ConsoleIO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Responsible for executing Biblioteca
class Runner {

    private static List<LibraryItem> generateItems() {
        Book halfGirlFriend = new Book("Half GirlFriend", "Chetan Bhagat", 2014);
        Book loveStory = new Book("Love Story", "Erich Segal", 1970);
        Book firstLove = new Book("First Love", "Ivan Turgenev", 1860);
        Movie twilight = new Movie("Twilight", 2009, "HardWicke", "8");
        Movie titanic = new Movie("Titanic", 1997, "Cameron", "9");
        return Arrays.asList(halfGirlFriend, loveStory, firstLove, twilight, titanic);
    }

    private static List<User> generateUsers() {
        User user1 = new User("srinu", "123", "123", "srinivas.aleti03@gmail.com", "9838918493");
        User user2 = new User("srinu", "1234", "1234", "srinivas.aleti03@gmail.com", "9838918493");

        return Arrays.asList(user1, user2);
    }

    public static void main(String args[]) {
        ConsoleIO consoleIO = new ConsoleIO(System.out, new Scanner(System.in));
        Library library = new Biblioteca(generateItems(), generateUsers());
        Factory commandFactory = new CommandFactoryBeforeLogin(library, consoleIO);
        MenuBeforeLogin menu = new MenuBeforeLogin(commandFactory, consoleIO);

        menu.launch();
    }

}

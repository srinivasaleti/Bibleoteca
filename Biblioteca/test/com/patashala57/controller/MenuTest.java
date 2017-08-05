package com.patashala57.controller;

import com.patashala57.model.Biblioteca;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {

    private IO mockIO;
    private Menu menu;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        Biblioteca biblioteca = new Biblioteca(null);
        Factory commandFactory = new CommandFactory(biblioteca, mockIO);
        this.menu = new Menu(commandFactory, this.mockIO);
    }

    @Test
    void displayMenu() {
        int wantedNumberOfInvocations = 2;

        menu.displayMenu();

        verify(mockIO, times(wantedNumberOfInvocations)).println("");
        verify(mockIO).println("Menu::");
        verify(mockIO).println("1->List Books");
        verify(mockIO).println("2->CheckOut a Book");
        verify(mockIO).println("3->Return a Book");
        verify(mockIO).println("4->List Movies");
        verify(mockIO).println("5->Checkout Movie");
        verify(mockIO).println("6->Return Movie");
        verify(mockIO).println("quit to EXIT");
    }

    @Test
    void displayWelcomeMessage() {
        String welcomeMessage = "Welcome To Bangalore Public Library";
        when(mockIO.getInput())
                .thenReturn("quit");
        menu.launch();

        verify(mockIO).println(welcomeMessage);
    }

    @Test
    void selectAOptionFromMenu() {
        String selectOption = "Select an Option From Menu::";

        menu.readMenuOptionFromUser();

        verify(mockIO).print(selectOption);
        verify(mockIO).getInput();
    }

    @Test
    void shouldExecuteACommand() {

    }

}

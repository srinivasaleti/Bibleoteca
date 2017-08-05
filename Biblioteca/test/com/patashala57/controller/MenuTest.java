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
        String header = "Menu::";
        String quit = "quit to EXIT";
        String listBooks = "1->List Books";
        String checkoutBook = "2->CheckOut a Book";
        String returnBook = "3->Return a Book";
        String listMovies = "4->List Movies";
        String checkoutMovie = "5->Checkout Movie";
        String returnMovie = "6->Return Movie";

        menu.displayMenu();

        verify(mockIO, times(wantedNumberOfInvocations)).println("");
        verify(mockIO).println(header);
        verify(mockIO).println(listBooks);
        verify(mockIO).println(checkoutBook);
        verify(mockIO).println(returnBook);
        verify(mockIO).println(listMovies);
        verify(mockIO).println(checkoutMovie);
        verify(mockIO).println(returnMovie);
        verify(mockIO).println(quit);
    }

    @Test
    void displayWelcomeMessage() {
        String welcomeMessage = "Welcome To Bangalore Public Library";
        String quit = "quit";

        when(mockIO.getInput())
                .thenReturn(quit);
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
    void getCommandFromCommandFactory() {
        Factory commandFactory = mock(Factory.class);
        QuitCommand quitCommand = new QuitCommand(mockIO);
        Menu menu = new Menu(commandFactory, mockIO);
        String quit = "quit";

        when(mockIO.getInput()).thenReturn(quit);
        when(commandFactory.getCommand(quit)).thenReturn(quitCommand);
        menu.launch();

        verify(commandFactory).getCommand(quit);
    }

    @Test
    void afterMenuSelectionProperCommandShouldExecute() {
        Command command = mock(Command.class);
        QuitCommand quitCommand = new QuitCommand(mockIO);
        Factory commandFactory = mock(CommandFactory.class);
        Menu menu = new Menu(commandFactory, mockIO);
        String input = "1";
        String quit = "quit";

        when(commandFactory.getCommand(input)).thenReturn(command);
        when(commandFactory.getCommand(quit)).thenReturn(quitCommand);
        when(mockIO.getInput())
                .thenReturn(input)
                .thenReturn(quit);
        menu.launch();

        verify(command).execute();
    }

}

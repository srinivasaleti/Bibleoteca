package com.patashala57.controller;

import com.patashala57.model.Biblioteca;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuAfterLoginTest {

    private IO mockIO;
    private Menu menu;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        Biblioteca biblioteca = new Biblioteca(null);
        Factory commandFactory = new CommandFactoryAfterLogin(biblioteca, this.mockIO);
        this.menu = new MenuAfterLogin(commandFactory, this.mockIO);
    }

    @Test
    void displayMenu() {
        int wantedNumberOfInvocations = 2;
        String header = "Menu::";
        String quitMessage = "quit to EXIT";
        String listBooks = "1->List Books";
        String checkoutBook = "2->CheckOut a Book";
        String returnBook = "3->Return a Book";
        String listMovies = "4->List Movies";
        String checkoutMovie = "5->Checkout Movie";
        String returnMovie = "6->Return Movie";
        String quit = "quit";

        when(this.mockIO.getInput())
                .thenReturn(quit);
        this.menu.launch();

        verify(this.mockIO, times(wantedNumberOfInvocations)).println("");
        verify(this.mockIO).println(header);
        verify(this.mockIO).println(listBooks);
        verify(this.mockIO).println(checkoutBook);
        verify(this.mockIO).println(returnBook);
        verify(this.mockIO).println(listMovies);
        verify(this.mockIO).println(checkoutMovie);
        verify(this.mockIO).println(returnMovie);
        verify(this.mockIO).println(quitMessage);
    }

    @Test
    void selectAOptionFromMenu() {
        String selectOption = "Select an Option From Menu::";
        String quit = "quit";

        when(this.mockIO.getInput())
                .thenReturn(quit);
        this.menu.launch();

        verify(this.mockIO).print(selectOption);
        verify(this.mockIO).getInput();
    }

    @Test
    void getCommandFromCommandFactory() {
        Factory commandFactory = mock(Factory.class);
        QuitCommand quitCommand = new QuitCommand(this.mockIO);
        MenuAfterLogin menu = new MenuAfterLogin(commandFactory, this.mockIO);
        String quit = "quit";

        when(this.mockIO.getInput()).thenReturn(quit);
        when(commandFactory.getCommand(quit)).thenReturn(quitCommand);
        menu.launch();

        verify(commandFactory).getCommand(quit);
    }

    @Test
    void afterMenuSelectionProperCommandShouldExecute() {
        Command command = mock(Command.class);
        QuitCommand quitCommand = new QuitCommand(this.mockIO);
        Factory commandFactory = mock(CommandFactoryAfterLogin.class);
        MenuAfterLogin menu = new MenuAfterLogin(commandFactory, this.mockIO);
        String input = "1";
        String quit = "quit";

        when(commandFactory.getCommand(input)).thenReturn(command);
        when(commandFactory.getCommand(quit)).thenReturn(quitCommand);
        when(this.mockIO.getInput())
                .thenReturn(input)
                .thenReturn(quit);
        menu.launch();

        verify(command).execute();
    }

}

package com.patashala57;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {

    private IO mockIO;
    private Biblioteca biblioteca;
    private Menu menu;

    @BeforeEach
    void beforeEach() {
        this.mockIO = mock(IO.class);
        this.biblioteca = mock(Biblioteca.class);
        this.menu = new Menu(this.biblioteca, this.mockIO);
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
        when(mockIO.getInput())
                .thenReturn("quit");

        verify(mockIO).print("displayWelcomeMessage");
    }

    @Test
    void readInputFromUser() {
        String selectOption = "Select an Option From Menu::";

        menu.readMenuOptionFromUser();

        verify(mockIO).print(selectOption);
        verify(mockIO).getInput();
    }


    @Test
    void listBookInLibrary() {
        when(mockIO.getInput())
                .thenReturn("1")
                .thenReturn("quit");
        menu.menuSelection();

        verify(biblioteca).displayItems(Book.class);
    }

    @Test
    void checkoutBookFromLibrary() {
        String bookName = "BookName";

        when(mockIO.getInput())
                .thenReturn("2")
                .thenReturn(bookName)
                .thenReturn("quit");
        menu.menuSelection();

        verify(biblioteca).checkoutItem(Book.class, bookName);
    }

    @Test
    void returnBookToLibrary() {
        String bookName = "BookName";

        when(mockIO.getInput())
                .thenReturn("3")
                .thenReturn(bookName)
                .thenReturn("quit");
    }

    @Test
    void listMoviesInLibrary() {
        when(mockIO.getInput())
                .thenReturn("4")
                .thenReturn("quit");
        menu.menuSelection();

        verify(biblioteca).displayItems(Movie.class);
    }

}

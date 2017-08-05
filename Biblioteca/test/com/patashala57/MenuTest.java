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
    void listBooksInLibrary() {
        when(mockIO.getInput())
                .thenReturn("1")
                .thenReturn("quit");
        menu.menuSelection();

        verify(biblioteca).stringRepresentationOfItems(Book.class);
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

        verify(biblioteca).stringRepresentationOfItems(Movie.class);
    }

    @Test
    void checkoutAMovieInLibrary(){
        String movieName = "MovieName";
        when(mockIO.getInput())
                .thenReturn("5")
                .thenReturn(movieName)
                .thenReturn("quit");
        menu.menuSelection();

        verify(biblioteca).checkoutItem(Movie.class,movieName);
    }

    @Test
    void returnAMovieToLibrary(){
        String movieName="MovieName";
        when(mockIO.getInput())
                .thenReturn("6")
                .thenReturn(movieName)
                .thenReturn("quit");
        menu.menuSelection();

        verify(biblioteca).returnItem(Movie.class,movieName);
    }

}

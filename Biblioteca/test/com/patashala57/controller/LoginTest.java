package com.patashala57.controller;

import com.patashala57.model.Library;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class LoginTest {

    private Library library;
    private IO mockIO;
    private Login login;

    @BeforeEach
    void beforeEach() {
        this.library = mock(Library.class);
        this.mockIO = mock(IO.class);
        this.login = new Login(this.library, this.mockIO);
    }

    @Test
    void readLibraryNoAndPasswordFromUser() {
        String enterLibraryNo = "Enter libraryNo::";
        String enterPassword = "Enter password::";
        String inValidLibraryNo = "inValidLibraryNo";
        String inValidPassword = "inValidPassword";

        when(this.mockIO.getInput()).thenReturn(inValidLibraryNo, inValidPassword);
        when(this.library.isValidUserCredentials(inValidLibraryNo, inValidPassword)).thenReturn(Optional.empty());

        this.login.execute();

        verify(this.mockIO).print(enterLibraryNo);
        verify(this.mockIO).print(enterPassword);
        verify(this.mockIO, times(2)).getInput();
    }

    @Test
    void askBibliotecaToVerifyGivenUserCredentialsAreExistedInRecord() {
        String inValidLibraryNo = "inValidLibraryNo";
        String inValidPassword = "inValidPassword";

        when(this.mockIO.getInput()).thenReturn(inValidLibraryNo, inValidPassword);
        when(this.library.isValidUserCredentials(inValidLibraryNo, inValidPassword)).thenReturn(Optional.empty());

        this.login.execute();

        verify(this.library).isValidUserCredentials(inValidLibraryNo, inValidPassword);
    }

    @Test
    void displayInvalidCredentialsAfterUnSuccessfulLogin() {
        String inValidLibraryNo = "inValidLibraryNo";
        String inValidPassword = "inValidPassword";
        String invalidCredentials = "Invalid Credentials";

        when(this.mockIO.getInput()).thenReturn(inValidLibraryNo, inValidPassword);
        when(this.library.isValidUserCredentials(inValidLibraryNo, inValidPassword)).thenReturn(Optional.empty());

        this.login.execute();

        verify(this.mockIO).println(invalidCredentials);
    }

//    @Test
//    void launchMenuAfterSuccessfulLogin() {
//        String validLibraryNo = "validLibraryNo";
//        String validPassword = "validPassword";
//
//        when(this.mockIO.getInput()).thenReturn(validLibraryNo, validPassword);
//        when(this.library.isValidUserCredentials(validLibraryNo, validPassword)).thenReturn(Optional.of(new User("1", "1", "1", "1", "1")));
//
//        this.login.execute();
//
//        verify(this.menu).launch();
//    }

}
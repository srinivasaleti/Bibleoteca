package com.patashala57.controller;

import com.patashala57.model.Biblioteca;
import com.patashala57.model.Library;
import com.patashala57.view.IO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CommandFactoryBeforeLoginTest {
    private CommandFactoryBeforeLogin factory;

    @BeforeEach
    void beforeEach() {
        IO mockIO = mock(IO.class);
        Library library = new Biblioteca(null);
        this.factory = new CommandFactoryBeforeLogin(library, mockIO);
    }

    @Test
    void expectedListBooksCommand() {
        assertEquals(this.factory.getCommand("1").getClass(), ListBooksCommand.class);
    }

    @Test
    void expectedListMoviesCommand(){
        assertEquals(this.factory.getCommand("2").getClass(),ListMoviesCommand.class);
    }

    @Test
    void expectedLoginCommand(){
        assertEquals(this.factory.getCommand("3").getClass(),Login.class);
    }

    @Test
    void expectedQuitCommand(){
        assertEquals(this.factory.getCommand("quit").getClass(),QuitCommand.class);
    }

    @Test
    void expectedInvalidCommand(){
        assertEquals(this.factory.getCommand("23").getClass(),InvalidCommand.class);
    }

}
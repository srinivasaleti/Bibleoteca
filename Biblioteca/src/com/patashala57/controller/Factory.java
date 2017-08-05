package com.patashala57.controller;

public interface Factory {

    void loadCommands();

    Command getCommand(String commandString);

}

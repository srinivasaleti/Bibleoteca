package com.patashala57.controller;

import com.patashala57.view.Command;

public interface Factory {

    void loadCommands();

    Command getCommand(String commandString);

}

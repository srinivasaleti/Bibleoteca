package com.patashala57;

interface Factory {

    void loadMaps();

    Command getCommand(String commandString);

}

package com.library.librarymanager;

public interface Entity {

    Integer getID();

    void readFromConsole() throws BadEntityException;

    void showOnConsole();

}


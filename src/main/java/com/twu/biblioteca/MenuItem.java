package com.twu.biblioteca;

abstract class MenuItem {
    Biblioteca biblioteca;

    public MenuItem(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }


    abstract void execute();
}

package com.twu.biblioteca;

abstract class MenuItem {
   private int actionNumber;
    Biblioteca biblioteca;

    public MenuItem(int actionNumber, Biblioteca biblioteca) {
        this.actionNumber = actionNumber;
        this.biblioteca = biblioteca;
    }

    abstract int getActionNumber();

    abstract void execute();
}

package com.twu.biblioteca;

public class Printer {

    public void print(String string) {
        System.out.println(string);
    }

    public void printMenu(int displayNumber, String displayString) {
        System.out.println(displayNumber + ".  " + displayString);
    }
}

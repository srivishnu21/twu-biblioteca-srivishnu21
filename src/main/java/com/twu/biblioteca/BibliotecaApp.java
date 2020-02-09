package com.twu.biblioteca;

public class BibliotecaApp {

    static Printer printer = new Printer();

    public static void main(String[] args) {
        printer.print(displayWelcomeMessage());
    }

    static String displayWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

}

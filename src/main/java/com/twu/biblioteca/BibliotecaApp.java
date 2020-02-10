package com.twu.biblioteca;

public class BibliotecaApp {

    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    static private Menu menu;

    public BibliotecaApp(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(welcomeMessage);
        menu.execute();
    }
}

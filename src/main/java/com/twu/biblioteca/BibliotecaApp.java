package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    static Printer printer = new Printer();
    static Reader reader;
    static private Menu menu;
    static private List<Book> books;
    static private List<Movie> movies;
    static private Biblioteca biblioteca;
    static private boolean loginStatus;
    static private UserAccount user;

    public BibliotecaApp(List<Book> books, List<Movie> movies, Reader reader) {
        BibliotecaApp.books = books;
        BibliotecaApp.movies = movies;
        BibliotecaApp.reader = reader;
        biblioteca = new Biblioteca(BibliotecaApp.books, BibliotecaApp.movies);
        menu = new Menu(BibliotecaApp.biblioteca, BibliotecaApp.reader);
        loginStatus = false;
    }

    public static UserAccount getUser() {
        return user;
    }

    public static void updateUser(UserAccount user) {
        BibliotecaApp.user = user;
    }

    public static boolean isLoggedIn() {
        return loginStatus;
    }

    public static void updateLoginStatus(boolean loginStatus) {
        BibliotecaApp.loginStatus = loginStatus;
    }

    public static void main(String[] args) {
        printer.print(welcomeMessage);
        menu.execute();
    }

}

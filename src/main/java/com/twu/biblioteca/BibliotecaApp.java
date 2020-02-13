package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    static Printer printer = new Printer();
    static Reader reader =new Reader();
    static private Menu menu;
    static private Login login;
    static private List<Book> books;
    static private List<Movie> movies;
    static private Biblioteca biblioteca;
    static private UserAccount user;

    public BibliotecaApp() {
        InputDetails inputDetails=new InputDetails();
        BibliotecaApp.books = inputDetails.getBooks();
        BibliotecaApp.movies = inputDetails.getMovie();
        BibliotecaApp.login = new Login(reader);
        biblioteca = new Biblioteca(BibliotecaApp.books, BibliotecaApp.movies);
        menu = new Menu(BibliotecaApp.biblioteca, BibliotecaApp.reader);
    }

    public static void main(String[] args) {
        new BibliotecaApp();
        printer.print(welcomeMessage);
        login.executeLoginAction();
    }

    public static void start(){
        menu.execute();
    }

    public static UserAccount getUser() {
        return user;
    }

    public static void updateUser(UserAccount user) {
        BibliotecaApp.user = user;
    }

}

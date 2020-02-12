package com.twu.biblioteca;

public class CheckOutMovie implements MenuItem {
    public final String successCheckOutMessage = "Thank you! Enjoy the movie.";
    public final String unSuccessCheckOutMessage = "Sorry, that movie is not available.";

    private Biblioteca biblioteca;
    private Reader reader;

    public CheckOutMovie(Biblioteca biblioteca, Reader reader) {
        this.biblioteca = biblioteca;
        this.reader = reader;
    }

    @Override
    public void executeAction() {
        biblioteca.displayMovieList();
        Printer printer = new Printer();
        printer.print("Please Enter the details of the movie want to checkout");
        String movieName = reader.getString();
        int releaseYear = reader.getInt();
        String director = reader.getString();
        double defaultRating = -1;
        if (biblioteca.checkOutMovie(new Movie(movieName, releaseYear, director, defaultRating))) {
            printer.print(successCheckOutMessage);
            return;
        }
        printer.print(unSuccessCheckOutMessage);
    }
}

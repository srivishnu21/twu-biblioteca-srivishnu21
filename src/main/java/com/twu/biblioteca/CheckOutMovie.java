package com.twu.biblioteca;

public class CheckOutMovie implements MenuItem {
    public final String successCheckOutMessage = "Thank you! Enjoy the movie.";
    public final String unSuccessCheckOutMessage = "Sorry, that movie is not available.";

    private Library library;
    private Reader reader;

    public CheckOutMovie(Library library, Reader reader) {
        this.library = library;
        this.reader = reader;
    }

    @Override
    public void executeAction() {
        library.displayList();
        Printer printer = new Printer();
        printer.print("Please Enter the details of the movie want to checkout");

        String movieName = reader.getString();
        int releaseYear = reader.getInt();
        String director = reader.getString();
        double defaultRating = -1;
        if (library.checkOutItem(new Movie(movieName, releaseYear, director, defaultRating))) {
            printer.print(successCheckOutMessage);
            return;
        }
        printer.print(unSuccessCheckOutMessage);
    }
}

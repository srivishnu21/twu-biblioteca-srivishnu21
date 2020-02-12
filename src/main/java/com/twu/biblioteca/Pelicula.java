package com.twu.biblioteca;

import java.util.List;

public class Pelicula {
    //Movies in spanish - pelicula

    private List<Movie> movies;

    public Pelicula(List<Movie> movies) {
        this.movies = movies;
    }

    public void DisplayMovies() {
        publish("Movie Name\t\tYear released\t\tDirector\t\tRatings");
    }

    private void publish(String message) {
        Printer printer = new Printer();
        printer.print(message);
    }
}

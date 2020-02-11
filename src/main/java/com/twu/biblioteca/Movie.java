package com.twu.biblioteca;

public class Movie {

    private String movieName;
    private int releaseYear;
    private String directorName;
    private double rating;

    public Movie(String movieName, int releaseYear, String directorName, double rating) {
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.directorName = directorName;
        this.rating = rating;
    }
}

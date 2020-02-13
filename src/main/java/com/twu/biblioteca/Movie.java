package com.twu.biblioteca;

import java.util.Objects;

public class Movie implements LibraryItems{

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

    public String toString() {
        if (rating == -1) {
            return movieName + "\t\t" + releaseYear + "\t\t" + directorName;
        }
        return movieName + "\t\t" + releaseYear + "\t\t" + directorName + "\t\t" + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear &&
                Objects.equals(movieName, movie.movieName) &&
                Objects.equals(directorName, movie.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, releaseYear, directorName);
    }
}

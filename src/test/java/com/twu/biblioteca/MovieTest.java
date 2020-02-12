package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTest {

    @Test
    void testShouldReturnValuesOfMovieInStringFormat() {
        Movie movie = new Movie("movie1", 2006, "xyz", 8.0);
        String expected = "movie1\t\t2006\t\txyz\t\t8.0";

        assertEquals(expected, movie.toString());
    }
}
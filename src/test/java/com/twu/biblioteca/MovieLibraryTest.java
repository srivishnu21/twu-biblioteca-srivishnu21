package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

class MovieLibraryTest {

    @Test
    void shouldCheckIfColumnNamesIsDisplayedAfterDisplayMoviesIsCalled() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<>());

        movieLibrary.displayList();

        verify(mockedPrintStream, times(1)).println("Movie Name\t\tYear released\t\tDirector\t\tRatings");
    }

    @Test
    void shouldCheckIfListOfBooksIsDisplayed() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        List<LibraryItems> movies = new ArrayList<>(Arrays.asList(new Movie("movie1", 2006, "xyz", 9.2)
                , new Movie("movie2", 2008, "xyz", 5.0)));
        MovieLibrary movieLibrary = new MovieLibrary(movies);

        movieLibrary.displayList();

        verify(mockedPrintStream, times(1)).println("Movie Name\t\tYear released\t\tDirector\t\tRatings");
        verify(mockedPrintStream, times(1)).println("movie1\t\t2006\t\txyz\t\t9.2\n" +
                "movie2\t\t2008\t\txyz\t\t5.0\n");
    }

    @Test
    void shouldCheckOutAMovieIfItIsPresent() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Movie movie1 = new Movie("movie1", 2006, "xyz", 9.2);
        Movie movie2 = new Movie("movie2", 2008, "xyz", 5.0);
        List<LibraryItems> movies = new ArrayList<>(Arrays.asList(movie1, movie2));
        MovieLibrary movieLibrary = new MovieLibrary(movies);

        assertTrue(movieLibrary.checkOutItem(new Movie("movie1", 2006, "xyz", 9.2)));
        assertFalse(movieLibrary.checkOutItem(new Movie("movie1", 2006, "xyz", 9.2)));
    }

    @Test
    void shouldCheckOutAMovieIfItIsNotPresent() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Movie movie1 = new Movie("movie1", 2006, "xyz", 9.2);
        Movie movie2 = new Movie("movie2", 2008, "xyz", 5.0);
        List<LibraryItems> movies = new ArrayList<>(Arrays.asList(movie1, movie2));
        MovieLibrary movieLibrary = new MovieLibrary(movies);

        assertFalse(movieLibrary.checkOutItem(new Movie("movie43234", 2006, "xyz", 9.2)));
    }

}
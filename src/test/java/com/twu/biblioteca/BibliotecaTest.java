package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    @Test
    void shouldDisplayListOfBooksAvailable() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());

        biblioteca.displayBookList();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABookItIsInLibrary() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());

        biblioteca.checkOutBook("book1");
        biblioteca.displayBookList();

        verify(mockedPrintStream, times(1)).println("book2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABookIfItContainsThenDisplaySuccessAMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());

        assertTrue(biblioteca.checkOutBook("book2"));
    }

    @Test
    void shouldCheckOutABookWhichIsNotInLibrary() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());

        biblioteca.checkOutBook("book1");
        biblioteca.checkOutBook("book1");

        assertTrue(biblioteca.checkOutBook("book2"));
        assertFalse(biblioteca.checkOutBook("book2"));
    }

    @Test
    void shouldThrowAUnSuccessfulMessageWhenBookItIsNotInLibrary() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());

        assertFalse(biblioteca.checkOutBook("hffhtdt"));
    }

    @Test
    void shouldAbleReturnABookAndDisplayASuccessMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());

        assertTrue(biblioteca.checkOutBook("book1"));
        assertTrue(biblioteca.returnBook("book1"));
    }

    @Test
    void shouldNotAbleReturnABookNotBelongsToThisLibraryAndDisplayAUnSuccessMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList, new ArrayList<>());
        biblioteca.returnBook("bsgb");

        assertFalse(biblioteca.checkOutBook("hffhtdt"));
    }

    @Test
    void shouldCheckIfColumnNamesIsDisplayedAfterDisplayMoviesIsCalled() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(new ArrayList<>(), new ArrayList<>());

        biblioteca.displayMovies();

        verify(mockedPrintStream, times(1)).println("Movie Name\t\tYear released\t\tDirector\t\tRatings");
    }

    @Test
    void shouldCheckIfListOfBooksIsDisplayed() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        List<Movie> movies = new ArrayList<>(Arrays.asList(new Movie("movie1", 2006, "xyz", 9.2)
                , new Movie("movie2", 2008, "xyz", 5.0)));
        Biblioteca biblioteca = new Biblioteca(new ArrayList<>(), movies);

        biblioteca.displayMovies();

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
        List<Movie> movies = new ArrayList<>(Arrays.asList(movie1, movie2));
        Biblioteca biblioteca = new Biblioteca(new ArrayList<>(), movies);

        assertTrue(biblioteca.checkOutMovie(new Movie("movie1", 2006, "xyz", 9.2)));
        assertFalse(biblioteca.checkOutMovie(new Movie("movie1", 2006, "xyz", 9.2)));
    }

    @Test
    void shouldCheckOutAMovieIfItIsNotPresent() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Movie movie1 = new Movie("movie1", 2006, "xyz", 9.2);
        Movie movie2 = new Movie("movie2", 2008, "xyz", 5.0);
        List<Movie> movies = new ArrayList<>(Arrays.asList(movie1, movie2));
        Biblioteca biblioteca = new Biblioteca(new ArrayList<>(), movies);

        assertFalse(biblioteca.checkOutMovie(new Movie("movie43234", 2006, "xyz", 9.2)));
    }


}
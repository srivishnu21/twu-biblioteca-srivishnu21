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
        Biblioteca biblioteca = new Biblioteca(bookList);

        biblioteca.displayBookList();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABookItIsInLibrary() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList);

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
        Biblioteca biblioteca = new Biblioteca(bookList);

        assertTrue(biblioteca.checkOutBook("book2"));
    }

    @Test
    void shouldCheckOutABookWhichIsNotInLibrary() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList);

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

        Biblioteca biblioteca = new Biblioteca(bookList);

        assertFalse(biblioteca.checkOutBook("hffhtdt"));
    }

    @Test
    void shouldAbleReturnABookAndDisplayASuccessMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList);

        assertTrue(biblioteca.checkOutBook("book1"));
        assertTrue(biblioteca.returnBook("book1"));
    }

    @Test
    void shouldNotAbleReturnABookNotBelongsToThisLibraryAndDisplayAUnSuccessMessage() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList);
        biblioteca.returnBook("bsgb");

        assertFalse(biblioteca.checkOutBook("hffhtdt"));
    }
}
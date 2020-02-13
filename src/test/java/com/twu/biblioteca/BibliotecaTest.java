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
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList);

        biblioteca.displayList();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc\nbook2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABookItIsInLibrary() {
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList);

        biblioteca.checkOutItem(new Book("book1",-1,""));
        biblioteca.displayList();

        verify(mockedPrintStream, times(1)).println("book2\t,\t2010\t,\txyz\n");
    }

    @Test
    void shouldCheckOutABookIfItContainsThenDisplaySuccessAMessage() {
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList);

        assertTrue(biblioteca.checkOutItem(new Book("book2",-1,"")));
    }

    @Test
    void shouldCheckOutABookWhichIsNotInLibrary() {
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Biblioteca biblioteca = new Biblioteca(bookList);

        biblioteca.checkOutItem(new Book("book1",-1,""));
        biblioteca.checkOutItem(new Book("book1",-1,""));

        assertTrue(biblioteca.checkOutItem(new Book("book2",-1,"")));
        assertFalse(biblioteca.checkOutItem(new Book("book2",-1,"")));
    }

    @Test
    void shouldThrowAUnSuccessfulMessageWhenBookItIsNotInLibrary() {
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList);

        assertFalse(biblioteca.checkOutItem(new Book("hffhtdt",-1,"")));
    }

    @Test
    void shouldAbleReturnABookAndDisplayASuccessMessage() {
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList);

        assertTrue(biblioteca.checkOutItem(new Book("book1",-1,"")));
        assertTrue(biblioteca.returnItem(new Book("book1",-1,"")));
    }

    @Test
    void shouldNotAbleReturnABookNotBelongsToThisLibraryAndDisplayAUnSuccessMessage() {
        List<LibraryItems> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        Biblioteca biblioteca = new Biblioteca(bookList);
        biblioteca.returnItem(new Book("bsgb",-1,""));

        assertFalse(biblioteca.checkOutItem(new Book("hffhtdt",-1,"")));
    }


}
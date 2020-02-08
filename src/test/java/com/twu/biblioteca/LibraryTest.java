package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class LibraryTest {

    @Test
    void shouldCheckAllBookNameInListGetsPrintedCorrectly() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2010, "ssv"),
                new Book("book2",2013,"jhb")));
        Library library = new Library(bookList);
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        library.displayListOfBooks();

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
        verify(mockedPrintStream, times(1)).println("book1 , 2010 , ssv");
        verify(mockedPrintStream, times(1)).println("book2 , 2013 , jhb");
    }

    @Test
    void shouldCheckAllDetailsOfBooksIsPrinted() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        Library library = new Library(bookList);
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        library.displayListOfBooks();

        verify(mockedPrintStream, times(1)).println("Book Name\t\tYear Published\t\tAuthor Name");
        verify(mockedPrintStream, times(1)).println("book1 , 2000 , abc");
        verify(mockedPrintStream, times(1)).println("book2 , 2010 , xyz");
    }
}
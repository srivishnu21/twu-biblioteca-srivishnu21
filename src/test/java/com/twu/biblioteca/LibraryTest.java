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
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1"), new Book("book2")));
        Library library = new Library(bookList);
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        library.displayListOfBooks();

        verify(mockedPrintStream, times(1)).println("book1");
        verify(mockedPrintStream, times(1)).println("book2");
    }

}
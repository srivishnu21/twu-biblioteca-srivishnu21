package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookKeeperTest {
    @Test
    void shouldCheckTheListOfAllBooksPrinted() {
        List<Book> bookList = new ArrayList<>(Arrays.asList(new Book("book1", 2000, "abc"),
                (new Book("book2", 2010, "xyz"))));
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BookKeeper bookKeeper=new BookKeeper(bookList);
        bookKeeper.displayListOfBooks();

        verify(mockedPrintStream, times(1)).println("book1\t,\t2000\t,\tabc");
        verify(mockedPrintStream, times(1)).println("book2\t,\t2010\t,\txyz");

    }

}
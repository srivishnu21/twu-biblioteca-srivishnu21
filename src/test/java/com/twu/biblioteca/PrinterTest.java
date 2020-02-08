package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

class PrinterTest {

    @Test
    void testShouldVerifyThatGivenStringIsPrinted() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Printer printer = new Printer();

        printer.printAString("Hello World");

        verify(mockedPrintStream, times(1)).println("Hello World");
    }

    @Test
    void testShouldVerifyThatAllDataMembersOfBookIsPrinted() {
        Book book = new Book("book1", 2019, "ssv");
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);
        Printer printer = new Printer();

        printer.printBookDetails(book);

        verify(mockedPrintStream, times(1)).println("book1\t,\t2019\t,\tssv");
    }
}
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
}
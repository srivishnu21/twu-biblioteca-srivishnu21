package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BibliotecaAppTest {

    @Test
    void shouldCheckIfDisplayWelcomeMessageIsPrintedOrNot() {
        PrintStream mockedPrintStream = mock(PrintStream.class);
        System.setOut(mockedPrintStream);

        BibliotecaApp.main(null);

        verify(mockedPrintStream,times(1)).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
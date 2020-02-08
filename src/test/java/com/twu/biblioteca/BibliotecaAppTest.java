package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaAppTest {

    @Test
    void shouldCheckIfDisplayWelcomeMessageFunctionReturnsCorrectString() {
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(expected, BibliotecaApp.displayWelcomeMessage());
    }


}
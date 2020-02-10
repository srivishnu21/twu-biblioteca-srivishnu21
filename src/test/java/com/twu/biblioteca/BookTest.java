package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    void shouldCheckIfToStringMethodReturnsCorrectBookDetails() {
        Book harryPotter = new Book("Harry Potter", 2003, "J.K Rowling");

        String expected = "Harry Potter\t,\t2003\t,\tJ.K Rowling";

        Assertions.assertEquals(expected,harryPotter.toString());
    }
}
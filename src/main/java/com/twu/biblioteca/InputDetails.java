package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputDetails {
    public InputDetails() {
    }

    public List<LibraryItems> getBooks() {
        return new ArrayList<>(Arrays.asList(new Book("harry potter",
                        2003, "J.k rowling"),
                new Book("Two states", 2005, "chetan bhagat"),
                new Book("Wings of fire", 2005, "apj")));
    }

    public List<LibraryItems> getMovie() {
        return new ArrayList<>(Arrays.asList(new Movie("Harry potter 1", 2003, "j.k rowling", 8.0)
                , new Movie("Harry potter 2", 2005, "j.k rowling", 9.0)));
    }
}

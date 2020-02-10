package com.twu.biblioteca;

import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);

    public int getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.nextLine();
    }
}

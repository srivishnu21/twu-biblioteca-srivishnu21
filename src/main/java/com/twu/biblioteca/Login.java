package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Login {
    Reader reader;
    private List<UserAccount> userAccounts;

    public Login(Reader reader) {
        this.reader = reader;
        this.userAccounts = new ArrayList<>();
        initializeUserAccount();
    }

    public void executeLoginAction() {
        Printer printer = new Printer();
        printer.print("Please Enter your Biblioteca Number");
        String userLibraryNumber = reader.getString();
        printer.print("Please Enter your Biblioteca Password");
        String userPassword = reader.getString();
        if (userAccounts.contains(new UserAccount(userLibraryNumber, userPassword))) {
            printer.print("You have successfully logged in");
        }
    }


    private void initializeUserAccount() {
        userAccounts.add(new UserAccount("123-6878", "password"));
        userAccounts.add(new UserAccount("123-7378", "password1"));
        userAccounts.add(new UserAccount("123-3949", "password2"));
        userAccounts.add(new UserAccount("123-4478", "password3"));
    }
}

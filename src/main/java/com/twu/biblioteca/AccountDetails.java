package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AccountDetails {

    private List<UserAccount> userAccounts;

    public AccountDetails() {
        userAccounts = new ArrayList<>();
        initializeUserAccount();
    }

    public boolean CheckValidUser(UserAccount userToCheck) {
        return userAccounts.contains(userToCheck);
    }

    private void initializeUserAccount() {
        userAccounts.add(new UserAccount("123-6878", "password"));
        userAccounts.add(new UserAccount("123-7378", "password1"));
        userAccounts.add(new UserAccount("123-3949", "password2"));
        userAccounts.add(new UserAccount("123-4478", "password3"));
    }
}

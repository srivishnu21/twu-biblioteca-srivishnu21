package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Login {
    private List<UserAccount> userAccounts;

    public Login() {
        this.userAccounts = new ArrayList<>();
        initializeUserAccount();
    }

    public void executeLoginAction(){
        Printer printer = new Printer();
    }


    private void initializeUserAccount() {
        userAccounts.add(new UserAccount("123-6878","password"));
        userAccounts.add(new UserAccount("123-7378","password1"));
        userAccounts.add(new UserAccount("123-3949","password2"));
        userAccounts.add(new UserAccount("123-4478","password3"));
    }
}

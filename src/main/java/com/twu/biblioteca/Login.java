package com.twu.biblioteca;

public class Login {
    private Reader reader;
    private AccountDetails accountDetails;

    public Login(Reader reader) {
        this.reader = reader;
        this.accountDetails = new AccountDetails();
    }


    public void executeLoginAction() {
        Printer printer = new Printer();
        printer.print("Please Enter your Biblioteca Number");
        String userLibraryNumber = reader.getString();
        printer.print("Please Enter your Biblioteca Password");
        String userPassword = reader.getString();
        UserAccount user = new UserAccount(userLibraryNumber, userPassword);
        if (accountDetails.CheckValidUser(user)) {
            printer.print("You have successfully logged in");
            BibliotecaApp.updateUser(user);
            BibliotecaApp.start();
        } else {
            printer.print("Entered password and library number is wrong. Please try again!");
//            executeLoginAction();
        }
    }
}

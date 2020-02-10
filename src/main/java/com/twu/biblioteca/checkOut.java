package com.twu.biblioteca;

public class checkOut extends MenuItem {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";
    private int actionNumber;
    private Reader reader;

    public checkOut(int actionNumber, Biblioteca biblioteca, Reader reader) {
        super(2, biblioteca);
        this.actionNumber = actionNumber;
        this.reader = reader;
    }

    @Override
    int getActionNumber() {
        return actionNumber;
    }

    @Override
    void execute() {
        biblioteca.displayBookList();
        Printer printer = new Printer();
        printer.print("Please Enter the name of the book want to checkout");
        String bookToCheckOut = reader.getString();
        if (biblioteca.checkOutBook(bookToCheckOut)) {
            printer.print(successCheckOutMessage);
            return;
        }
        printer.print(unSuccessCheckOutMessage);
    }
}

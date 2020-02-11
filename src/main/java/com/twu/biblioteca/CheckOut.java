package com.twu.biblioteca;

public class CheckOut implements MenuItem {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";

    private Reader reader;
    private Biblioteca biblioteca;

    public CheckOut(Biblioteca biblioteca, Reader reader) {
        this.biblioteca = biblioteca;
        this.reader = reader;
    }

    @Override
    public void executeAction() {
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

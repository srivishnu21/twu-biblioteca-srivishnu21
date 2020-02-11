package com.twu.biblioteca;

public class CheckOut extends MenuItem {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";
    private Reader reader;

    public CheckOut(Biblioteca biblioteca, Reader reader) {
        super(biblioteca);
        this.reader = reader;
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

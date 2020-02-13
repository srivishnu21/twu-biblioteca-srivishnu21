package com.twu.biblioteca;

public class CheckOutBook implements MenuItem {
    public final String successCheckOutMessage = "Thank you! Enjoy the book.";
    public final String unSuccessCheckOutMessage = "Sorry, that book is not available.";

    private Reader reader;
    private Library library;

    public CheckOutBook(Reader reader, Library library) {
        this.reader = reader;
        this.library = library;
    }

    @Override
    public void executeAction() {
        library.displayList();
        Printer printer = new Printer();
        printer.print("Please Enter the name of the book want to checkout");
        reader.getString();
        String bookToCheckOut = reader.getString();
        Book book = new Book(bookToCheckOut, -1, "");
        if (library.checkOutItem(book)) {
            printer.print(successCheckOutMessage);
            return;
        }
        printer.print(unSuccessCheckOutMessage);
    }
}

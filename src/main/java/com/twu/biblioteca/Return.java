package com.twu.biblioteca;

public class Return implements MenuItem {
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";

    private Reader reader;
    private Biblioteca biblioteca;

    public Return(Biblioteca biblioteca, Reader reader) {
        this.biblioteca = biblioteca;
        this.reader = reader;
    }

    @Override
    public void executeAction() {
        Printer printer = new Printer();
        System.out.println(3);
        printer.print("Please Enter the name of the book want to return");
        String bookToReturn = reader.getString();
        if (biblioteca.returnBook(bookToReturn)) {
            printer.print(successReturnMessage);
            return;
        }
        printer.print(unSuccessReturnMessage);
    }
}

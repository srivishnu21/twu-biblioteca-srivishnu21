package com.twu.biblioteca;

public class Return implements MenuItem {
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";

    private Reader reader;
    private Library library;

    public Return(Reader reader, Library library) {
        this.reader = reader;
        this.library = library;
    }

    @Override
    public void executeAction() {
        Printer printer = new Printer();
        System.out.println(3);
        printer.print("Please Enter the name of the book want to return");
        String bookToReturn = reader.getString();
        if (library.returnItem(new Book(bookToReturn,-1,""))) {
            printer.print(successReturnMessage);
            return;
        }
        printer.print(unSuccessReturnMessage);
    }
}

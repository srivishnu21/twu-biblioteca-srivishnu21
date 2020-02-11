package com.twu.biblioteca;

public class Return extends MenuItem {
    public final String successReturnMessage = "Thank you for returning the book.";
    public final String unSuccessReturnMessage = "That is not a valid book to return.";

    private Reader reader;

    public Return(Biblioteca biblioteca, Reader reader) {
        super(biblioteca);
        this.reader = reader;
    }

    @Override
    void execute() {
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

package com.patashala57;

//Responsible to ReturnBook to bibiloteca
class ReturnBookCommand implements Command {

    private static final String ENTER_BOOK_Name = "Enter Book Name to return::";
    private static final String SUCCESS_MESSAGE = "Thank you for returning the book";
    private static final String UNSUCCESS_MESSAGE = "That is not a valid book to return";

    private Library library;
    private IO consoleIO;

    ReturnBookCommand(Library library, IO consoleIO) {
        this.library = library;
        this.consoleIO=consoleIO;
    }

    @Override
    public void execute() {
        consoleIO.print(ENTER_BOOK_Name);
        String bookName = consoleIO.getInput();
        boolean isReturn= library.returnItem(Book.class,bookName);
        displayMessage(isReturn);
    }

    private void displayMessage(boolean isReturn) {
        if (isReturn) {
            consoleIO.println(SUCCESS_MESSAGE);
        } else {
            consoleIO.println(UNSUCCESS_MESSAGE);
        }
    }

}

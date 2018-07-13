package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;

import java.io.IOException;

public class CheckOutMenu implements Menu {

    private InputCommand inputCommand;

    public CheckOutMenu(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }

    @Override
    public void enter() {
        try {
            String bookname = inputCommand.input("Please input the book name:\r\n");
            Book book = BookRepository.instance().queryByName(bookname);
            if(book == null){
                System.out.println("Sorry! \""+bookname+"\" is not in our library!");
                System.out.println("----------------------------");
                return;
            }
            if (!book.checkable()) {
                System.out.println("Sorry! \""+bookname+"\" has been checked out!");
                System.out.println("----------------------------");
                return;
            }
            book.checkout();
            System.out.println("Successfully checked out!");
            System.out.println("----------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

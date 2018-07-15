package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;

import java.io.IOException;

public class ReturnMenu implements Menu{

    private final InputCommand inputCommand;

    public ReturnMenu(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }

    @Override
    public int enter() {
        try {
            String bookname = inputCommand.input("Please input the book's name:\r\n");
            Book book = BookRepository.instance().queryByName(bookname);
            if(book == null){
                System.out.println("Sorry! \""+bookname+"\" is not our book!");
                System.out.println("----------------------------");
                return 0;
            }
            if (book.checkable()) {
                System.out.println("Sorry! \""+bookname+"\" is already in our library!");
                System.out.println("----------------------------");
                return 0;
            }
            book.returned();
            System.out.println("Successfully returned!");
            System.out.println("----------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String title() {
        return "Return";
    }

}

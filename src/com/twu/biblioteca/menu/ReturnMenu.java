package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.UserRepository;

import java.io.IOException;

public class ReturnMenu implements Menu{

    private final InputCommand inputCommand;

    public ReturnMenu(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }

    @Override
    public int enter() {
        try {
            if (!UserRepository.instance().isLogin()) {
                System.out.println("Please login:");
                int status = new LoginMenu(inputCommand).enter();
                if (status == LoginMenu.LOGIN_FAILURE) {
                    return 0;
                }
            }

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
            book.returnToLibrary();
            System.out.println("Successfully returnToLibrary!");
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

    @Override
    public boolean auth(User user) {
        return true;
    }

}

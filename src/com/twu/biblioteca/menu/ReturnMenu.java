package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.serivce.ReturnService;
import org.mockito.internal.stubbing.answers.Returns;

import java.io.IOException;

public class ReturnMenu implements Menu{

    private final InputCommand inputCommand;

    private ReturnService returnService = new ReturnService();

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

            String name = inputCommand.input("Please input the book's name:\r\n");

            int state = returnService.returnItem(name);
            if(state == ReturnService.STATE_RETURN_FAILURE_NOT_EXIST){
                System.out.println("Sorry! \""+name+"\" is not our book!");
                System.out.println("----------------------------");
                return 0;
            }
            if (state == ReturnService.STATE_RETURN_FAILURE_ALREADY_RETURNED) {
                System.out.println("Sorry! \""+name+"\" is already in our library!");
                System.out.println("----------------------------");
                return 0;
            }
            if (state == ReturnService.STATE_RETURN_FAILURE_NO_LOGIN) {
                return enter();
            }

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

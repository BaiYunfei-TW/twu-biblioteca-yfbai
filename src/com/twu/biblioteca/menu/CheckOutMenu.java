package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.serivce.CheckoutService;

import java.io.IOException;

public class CheckOutMenu implements Menu {

    private InputCommand inputCommand;

    private CheckoutService checkoutService = new CheckoutService();

    public CheckOutMenu(InputCommand inputCommand) {
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
            String name = inputCommand.input("Please input the Book&Movie's name:\r\n");
            int state = checkoutService.checkout(name);
            if(state == CheckoutService.STATE_CHECKOUT_FAILURE_NOT_EXIST){
                System.out.println("Sorry! \""+name+"\" is not in our library!");
                System.out.println("----------------------------");
                return 0;
            }
            if (state == CheckoutService.STATE_CHECKOUT_FAILURE_NOT_IN_LIBRARY) {
                System.out.println("Sorry! \""+name+"\" has been checked out!");
                System.out.println("----------------------------");
                return 0;
            }
            if (state == CheckoutService.STATE_CHECKOUT_SUCCESS) {
                System.out.println("Successfully checked out!");
                System.out.println("----------------------------");
            }
            if (state == CheckoutService.STATE_NO_LOGIN) {
                enter();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String title() {
        return "Checkout";
    }

    @Override
    public boolean auth(User user) {
        return true;
    }
}

package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.UserSerivce;

import java.io.IOException;

public class LoginMenu implements Menu {

    private InputCommand inputCommand;
    private UserSerivce userSerivce = new UserSerivce();

    public static final int LOGIN_SUCCESS = 201;
    public static final int LOGIN_FAILURE = 501;

    public LoginMenu(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }

    @Override
    public int enter() {
        String account = null;
        String password = null;
        try {
            account = inputCommand.input("Account:\r\n");
            password = inputCommand.input("Password:\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = userSerivce.login(account, password);
        if (user == null) {
            System.out.println("Sorry. Your password or account is incorrect.");
            return LOGIN_FAILURE;
        }
        System.out.println("Successfully login!");
        System.out.println("----------------------------");
        return LOGIN_SUCCESS;
    }

    @Override
    public String title() {
        return "Login";
    }

    @Override
    public boolean auth(User user) {
        return user == null;
    }
}

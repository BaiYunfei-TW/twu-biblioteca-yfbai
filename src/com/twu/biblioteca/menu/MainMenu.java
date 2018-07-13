package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;

import java.io.IOException;

public class MainMenu implements Menu {

    private InputCommand inputCommand;

    public MainMenu(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }

    @Override
    public void enter() {
        System.out.println("1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------");
        try {
            String option = inputCommand.input(">");
            int optionNumber = Integer.parseInt(option);
            switch (optionNumber) {
                case 0:
                    System.out.println("Bye");
                    return;
                case 1:
                    new ListBookMenu().enter();
                    enter();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

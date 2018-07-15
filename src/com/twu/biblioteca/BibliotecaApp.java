package com.twu.biblioteca;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.menu.MainMenu;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    public void start() {
        InputCommand inputCommand = new InputCommand();
        start(inputCommand);
    }

    public void start(InputCommand inputCommand) {
        new MainMenu(inputCommand).enter();
    }
}

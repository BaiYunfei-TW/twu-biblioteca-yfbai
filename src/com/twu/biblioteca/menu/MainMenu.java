package com.twu.biblioteca.menu;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.UserRepository;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu implements Menu {

    private static final int MENU_CODE_QUIT = -1;

    private InputCommand inputCommand;

    private Map<String, Menu> menuMap;

    public MainMenu(InputCommand inputCommand) {
        this.inputCommand = inputCommand;

        menuMap = new LinkedHashMap<>();
        //update menus
        updateMenus();
    }

    private void updateMenus() {
        menuMap.clear();
        menuMap.put("1", new ListBookMenu());
        menuMap.put("2", new ListMovieMenu());
        menuMap.put("3", new CheckOutMenu(inputCommand));
        menuMap.put("4", new ReturnMenu(inputCommand));
        menuMap.put("5", new CheckoutRecordMenu());
        menuMap.put("7", new UserInfoMenu());
        menuMap.put("9", new LoginMenu(inputCommand));

        menuMap.put("0", new QuitMenu());
    }

    @Override
    public int enter() {
        updateMenus();

        for (String key : menuMap.keySet()) {
            if (menuMap.get(key).auth(UserRepository.instance().getLoginedUser())) {
               System.out.printf("%s. %s\r\n", key, menuMap.get(key).title());
            }
        }
        System.out.println("----------------------------");

        try {
            String option = inputCommand.input(">");

            Menu menu = menuMap.get(option);

            int returnCode = menu.enter();
            if (returnCode == MENU_CODE_QUIT) {
                return -1;
            }

            enter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String title() {
        return "Main Menu";
    }

    @Override
    public boolean auth(User user) {
        return true;
    }

    private class QuitMenu implements Menu {

        @Override
        public int enter() {
            System.out.println("Bye");
            return MENU_CODE_QUIT;
        }

        @Override
        public String title() {
            return "Quit";
        }

        @Override
        public boolean auth(User user) {
            return true;
        }
    }
}

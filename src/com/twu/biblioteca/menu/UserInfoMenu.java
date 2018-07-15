package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.UserRepository;

public class UserInfoMenu implements Menu {

    UserRepository userRepository = UserRepository.instance();

    @Override
    public int enter() {
        User user = userRepository.getLoginedUser();
        if (user == null) {
            System.out.println("Sorry. You haven't login yet.");
            return 0;
        }
        System.out.print(user.getInfo());
        return 0;
    }

    @Override
    public String title() {
        return "My Information";
    }

    @Override
    public boolean auth(User user) {
        return user != null;
    }
}

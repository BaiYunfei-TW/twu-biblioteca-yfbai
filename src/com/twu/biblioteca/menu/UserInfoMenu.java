package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.UserRepository;

public class UserInfoMenu implements Menu {

    UserRepository userRepository = UserRepository.instance();

    @Override
    public void enter() {
        User user = userRepository.getLoginedUser();
        if (user == null) {
            System.out.println("Sorry. You haven't login yet.");
            return;
        }
        System.out.print(user.getInfo());
    }
}

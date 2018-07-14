package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.UserRepository;

public class UserSerivce {

    UserRepository userRepository = UserRepository.instance();

    public User login(String account, String password) {
        User actualUser = userRepository.queryByUsername(account);
        if (actualUser == null) {
            return null;
        }
        if (!actualUser.getPassword().equals(password)) {
            return null;
        }
        //successfully login
        userRepository.setLoginedUser(actualUser);
        return actualUser;
    }

}

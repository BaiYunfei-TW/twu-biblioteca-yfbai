package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private static final UserRepository userRepository;

    private final List<User> users = new ArrayList<>();

    static {
        userRepository = new UserRepository();
    }

    private UserRepository() {
        init();
    }

    public void init() {
        users.addAll(Arrays.asList(
                new User(1, "001-0001", "123456"),
                new User(2, "001-0002", "111111")
        ));
    }

    public static UserRepository instance() {
        return new UserRepository();
    }

    public User queryByUsername(String username) {
        for (User u :
                users) {
            if (u.getAccount().equals(username)) {
                return u;
            }
        }
        return null;
    }
}

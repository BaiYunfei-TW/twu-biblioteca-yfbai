package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {

    private static final UserRepository userRepository;

    private final List<User> users = new ArrayList<>();

    private User loginedUser;

    static {
        userRepository = new UserRepository();
    }

    private UserRepository() {
        init();
    }

    public void init() {
        users.addAll(Arrays.asList(
                new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517", User.ROLE_MANAGER),
                new User(2, "001-0002", "111111", "xiaoming", "xiaoming@tw.com", "15626299518")
        ));
        this.loginedUser = null;
    }

    public static UserRepository instance() {
        return userRepository;
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

    public User getLoginedUser() {
        return this.loginedUser;
    }

    public void setLoginedUser(User loginedUser) {
        this.loginedUser = loginedUser;
    }

    public boolean isLogin() {
        return this.loginedUser != null;
    }
}

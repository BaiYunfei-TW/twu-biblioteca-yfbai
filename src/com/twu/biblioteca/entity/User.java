package com.twu.biblioteca.entity;

public class User {
    private final int id;
    private String account;
    private String password;

    public User(int id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return this.account;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        User u = (User) obj;
        return u.id == this.id &&
                u.getAccount().equals(this.account) &&
                u.getPassword().equals(this.password);
    }

    public String getPassword() {
        return this.password;
    }
}

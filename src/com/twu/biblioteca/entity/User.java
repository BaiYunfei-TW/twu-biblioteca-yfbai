package com.twu.biblioteca.entity;

public class User {
    private final int id;
    private String account;
    private String password;
    private String name;
    private String email;
    private String tel;

    public User(int id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public User(int id, String account, String password, String name, String email, String tel) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.tel = tel;
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

    public String getInfo() {
        return String.format(
                "Id: %d\r\n" +
                "Account: %s\r\n" +
                "Name: %s\r\n" +
                "Email: %s\r\n" +
                "Tel: %s\r\n" ,
                id,
                account,
                name,
                email,
                tel
        );
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTel() {
        return this.tel;
    }
}

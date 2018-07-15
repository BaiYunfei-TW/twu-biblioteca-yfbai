package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.User;

public interface Menu {

    int enter();

    String title();

    boolean auth(User user);
}

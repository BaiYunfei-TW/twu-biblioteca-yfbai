package com.twu.biblioteca.entity;

public interface Checkable {

    String info();

    String type();

    boolean checkable();

    void checkout();

    String name();

    int getId();

    void returnToLibrary();
}

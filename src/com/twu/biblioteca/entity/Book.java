package com.twu.biblioteca.entity;

public class Book implements Checkable{
    public static final String STATE_IN_LIBRARY = "in_library";
    public static final String STATE_CHECKED_OUT = "checked_out";
    private String author;
    private int year;
    private int id;
    private String name;
    private String state;

    public Book(int id, String name, String author, int year) {
        this(id, name, author, year, STATE_IN_LIBRARY);
    }

    public Book(int id, String name, String author, int year, String state) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.state = state;
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) {
            return false;
        }
        return this.id == ((Book)obj).id;
    }

    @Override
    public String toString() {
        return String.format("%d. %s | %s | %d", id, name, author, year);
    }

    @Override
    public boolean checkable() {
        if (this.state.equals(STATE_IN_LIBRARY)) {
            return true;
        }
        return false;
    }

    @Override
    public void checkout() {
        this.state = STATE_CHECKED_OUT;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void returnToLibrary() {
        this.state = STATE_IN_LIBRARY;
    }

    @Override
    public String info() {
        return String.format(
                "%s.%s.%d",
                this.name,
                this.author,
                this.year
        );
    }

    @Override
    public String type() {
        return "Book";
    }
}

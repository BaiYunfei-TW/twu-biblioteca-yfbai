package com.twu.biblioteca.entity;

public class Movie implements Checkable {

    public static final String STATE_CHECKED_OUT = "checked_out";
    public static final String STATE_IN_LIBRARY = "in_library";

    private int id;
    private String name;
    private String director;
    private int year;
    private String rating;
    private String state;

    public Movie(int id, String name, int year, String director, String rating) {
        this(id, name, year, director, rating, STATE_IN_LIBRARY);
    }

    public Movie(int id, String name, int year, String director, String rating, String state) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.state = state;
    }

    @Override
    public boolean checkable() {
        return STATE_IN_LIBRARY.equals(this.state);
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

    @Override
    public void returnToLibrary() {
        this.state = STATE_IN_LIBRARY;
    }

    @Override
    public String toString() {
        return String.format("%d. %s | %d | %s | %s |", id, name, year, director, rating);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Movie)) {
            return false;
        }
        return this.id == ((Movie)obj).id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String info() {
        return String.format("%s.%s.%d", name, director, year);
    }

    @Override
    public String type() {
        return "Movie";
    }
}

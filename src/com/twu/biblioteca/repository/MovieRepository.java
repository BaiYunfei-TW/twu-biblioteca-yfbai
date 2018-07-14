package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    public static final MovieRepository movieRepository;

    private List<Movie> movieList;

    static {
        movieRepository = new MovieRepository();
    }

    private MovieRepository() {
        init();
    }

    public void init() {
        movieList = Arrays.asList(
                new Movie(1, "Superman", 2005, "Henry", "9.1"),
                new Movie(2, "Spyderman", 2006, "Peter", "8.5")
        );
    }

    public static MovieRepository instance() {
        return movieRepository;
    }

    public List<Movie> getCheckableMovies() {
        List<Movie> result = new ArrayList<>();
        for (Movie m : movieList) {
            if (m.checkable()) {
                result.add(m);
            }
        }
        return result;
    }

    public Movie queryByName(String name) {
        for (Movie m :
                movieList) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }
}

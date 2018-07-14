package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repository.MovieRepository;

public class ListMovieMenu implements Menu {

    MovieRepository movieRepository = MovieRepository.instance();

    @Override
    public void enter() {
        System.out.println("Movie List:");
        System.out.println("----------------------------");
        for (Movie m :
                movieRepository.getCheckableMovies()) {
            System.out.println(m.toString());
        }
        System.out.println("----------------------------");
    }
}

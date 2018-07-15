package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.MovieRepository;

public class ListMovieMenu implements Menu {

    MovieRepository movieRepository = MovieRepository.instance();

    @Override
    public int enter() {
        System.out.println("Movie List:");
        System.out.println("----------------------------");
        for (Movie m :
                movieRepository.getCheckableMovies()) {
            System.out.println(m.toString());
        }
        System.out.println("----------------------------");
        return 0;
    }

    @Override
    public String title() {
        return "List Movies";
    }

    @Override
    public boolean auth(User user) {
        return true;
    }
}

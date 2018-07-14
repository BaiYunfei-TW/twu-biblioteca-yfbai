package com.twu.biblioteca.repository;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieRepositoryTest extends BaseTest {

    private MovieRepository movieRepository;

    @Before
    public void init() {
        this.movieRepository = MovieRepository.instance();
    }

    @Test
    public void should_return_checkable_movie_list_after_initialize() {
        List<Movie> actual = movieRepository.getCheckableMovies();

        List<Movie> excepted = Arrays.asList(
                new Movie(1, "Superman", 2005, "Henry", "9.1"),
                new Movie(2, "Spyderman", 2006, "Peter", "8.5"));

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_right_Movie_object_when_query_by_movie_name_exist_in_repository() {
        Movie excepted = new Movie(1, "Superman", 2005, "Henry", "9.1");
        Movie actual = movieRepository.queryByName("Superman");

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_null_when_query_by_movie_name_not_exists_in_repository() {
        Movie excepted = null;
        Movie actual = movieRepository.queryByName("What");

        assertEquals(excepted, actual);
    }

}

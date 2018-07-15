package com.twu.biblioteca.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void should_return_true_when_the_movie_is_in_library() {
        boolean excepted = true;

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1");
        boolean actual = movie.checkable();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_false_when_the_movie_is_already_checked_out() {
        boolean excepted = false;

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1", Movie.STATE_CHECKED_OUT);
        boolean actual = movie.checkable();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_false_after_checking_out_the_movie() {
        boolean excepted = false;

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1");
        movie.checkout();
        boolean actual = movie.checkable();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_toString_return_movie_details() {
        String excepted = "1. Superman | 2005 | Henry | 9.1 |";

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1");

        assertEquals(excepted, movie.toString());
    }

    @Test
    public void should_checkable_return_true_when_a_movie_was_returned() {
        boolean excepted = true;

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1", Movie.STATE_CHECKED_OUT);
        movie.returnToLibrary();

        assertEquals(excepted, movie.checkable());
    }
    
}

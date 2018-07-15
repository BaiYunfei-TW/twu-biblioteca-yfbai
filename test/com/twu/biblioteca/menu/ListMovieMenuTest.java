package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListMovieMenuTest extends BaseTest {

    private ListMovieMenu listMovieMenu = new ListMovieMenu();

    @Test
    public void should_print_checkable_book_list_when_enter() {
        String excepted =   "Movie List:\r\n" +
                "----------------------------\r\n" +
                "1. Superman | 2005 | Henry | 9.1 |\r\n" +
                "2. Spyderman | 2006 | Peter | 8.5 |\r\n" +
                "----------------------------\r\n";
        listMovieMenu.enter();

        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_user() {
        login();

        boolean actual = new ListMovieMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_manager() {
        loginByManager();

        boolean actual = new ListMovieMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_before_login() {
        boolean actual = new ListMovieMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }
}

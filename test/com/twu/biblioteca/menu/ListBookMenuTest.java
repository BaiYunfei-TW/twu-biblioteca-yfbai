package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;

import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListBookMenuTest extends BaseTest {

    private ListBookMenu listBookMenu = new ListBookMenu();

    @Test
    public void should_print_checkable_book_list_when_enter() {
        String excepted =   "Book List:\r\n" +
                            "----------------------------\r\n" +
                            "1. Head First Java | Bert Bates, Kathy Sierra | 2005\r\n" +
                            "2. Thinking in Java | Bruce Eckel | 2006\r\n" +
                            "----------------------------\r\n";
        listBookMenu.enter();

        assertEquals(excepted, printedContent());
    }


    @Test
    public void should_return_true_when_require_authorization_after_login_by_user() {
        login();

        boolean actual = new ListBookMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_manager() {
        loginByManager();

        boolean actual = new ListBookMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_before_login() {
        boolean actual = new ListBookMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }
}

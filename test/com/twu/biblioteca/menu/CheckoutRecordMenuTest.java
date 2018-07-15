package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutRecordMenuTest extends BaseTest {

    @Test
    public void should_print_checked_out_records() {
        String excepted = "Type | Item details | Checkout Time | Return Time |Account | Name | Email | Tel\r\n" +
                "----------------------------\r\n" +
                "Book | Design Patterns.Erich Gamma.2001 | 2018-01-01 10:00:00 | - | 001-0001 | yfbai | baiyunfeiii@foxmail.com | 15626299517\r\n" +
                "----------------------------\r\n";

        CheckoutRecordMenu checkoutRecordMenu = new CheckoutRecordMenu();
        checkoutRecordMenu.enter();

        assertEquals(excepted, printedContent());
    }


    @Test
    public void should_return_true_when_require_authorization_after_login_by_user() {
        login();

        boolean actual = new CheckoutRecordMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = false;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_manager() {
        loginByManager();

        boolean actual = new CheckoutRecordMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_false_when_require_authorization_before_login() {
        login();

        boolean actual = new CheckoutRecordMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = false;

        assertEquals(excepted, actual);
    }
}

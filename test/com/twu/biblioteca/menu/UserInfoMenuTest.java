package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.service.UserSerivce;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInfoMenuTest extends BaseTest {

    UserSerivce userSerivce = new UserSerivce();

    @Test
    public void should_print_user_s_information_when_user_has_login() {
        userSerivce.login("001-0001", "123456");

        UserInfoMenu userInfoMenu = new UserInfoMenu();
        userInfoMenu.enter();

        String excepted =   "Id: 1\r\n" +
                            "Account: 001-0001\r\n" +
                            "Name: yfbai\r\n" +
                            "Email: baiyunfeiii@foxmail.com\r\n" +
                            "Tel: 15626299517\r\n" +
                            "----------------------------\r\n";

        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_print_no_login_message_when_user_has_not_login() {
        UserInfoMenu userInfoMenu = new UserInfoMenu();
        userInfoMenu.enter();

        String excepted =   "Sorry. You haven't login yet.\r\n" +
                "----------------------------\r\n";

        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_user() {
        login();

        boolean actual = new UserInfoMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_manager() {
        loginByManager();

        boolean actual = new UserInfoMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_before_login() {
        boolean actual = new UserInfoMenu().auth(UserRepository.instance().getLoginedUser());
        boolean excepted = false;

        assertEquals(excepted, actual);
    }
}

package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginMenuTest extends BaseTest {

    UserRepository userRepository = UserRepository.instance();

    @Test
    public void test_login_successfully_given_correct_account_and_password() throws IOException {
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Account:\r\n")).thenReturn("001-0001");
        when(inputCommand.input("Password:\r\n")).thenReturn("123456");

        LoginMenu loginMenu = new LoginMenu(inputCommand);
        loginMenu.enter();

        User exceptedUser = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");
        User loginedUser = userRepository.getLoginedUser();

        assertEquals(exceptedUser, loginedUser);

        String exceptedOutput = "Successfully login!\r\n" +
                "----------------------------\r\n";
        assertEquals(exceptedOutput, printedContent());
    }

    @Test
    public void test_login_failure_given_incorrect_account_and_password() throws IOException {
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Account:\r\n")).thenReturn("001-0002");
        when(inputCommand.input("Password:\r\n")).thenReturn("123456");

        LoginMenu loginMenu = new LoginMenu(inputCommand);
        loginMenu.enter();

        User exceptedUser = null;
        User loginedUser = userRepository.getLoginedUser();

        assertEquals(exceptedUser, loginedUser);

        String exceptedOutput = "Sorry. Your password or account is incorrect.\r\n";
        assertEquals(exceptedOutput, printedContent());
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_user() {
        login();

        boolean actual = new LoginMenu(inputCommand).auth(UserRepository.instance().getLoginedUser());
        boolean excepted = false;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_manager() {
        loginByManager();

        boolean actual = new LoginMenu(inputCommand).auth(UserRepository.instance().getLoginedUser());
        boolean excepted = false;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_before_login() {
        boolean actual = new LoginMenu(inputCommand).auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }
}
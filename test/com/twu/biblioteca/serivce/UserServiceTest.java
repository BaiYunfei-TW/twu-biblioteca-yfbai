package com.twu.biblioteca.serivce;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.UserSerivce;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest extends BaseTest {

    UserSerivce userSerivce = new UserSerivce();

    @Test
    public void test_login_should_return_user_object_when_given_right_username_and_password() {
        User user = userSerivce.login("001-0001", "123456");

        User excepted = new User(1, "001-0001", "123456");

        assertEquals(excepted, user);
    }

    @Test
    public void test_login_should_return_null_when_given_username_which_is_not_exist() {
        User user = userSerivce.login("Tom", "123456");

        User excepted = null;

        assertEquals(excepted, user);
    }

    @Test
    public void test_login_should_return_user_object_when_given_right_username_and_wrong_password() {
        User user = userSerivce.login("001-0001", "111111");

        User excepted = null;

        assertEquals(excepted, user);
    }
}

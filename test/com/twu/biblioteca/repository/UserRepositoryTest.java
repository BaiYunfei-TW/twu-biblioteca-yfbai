package com.twu.biblioteca.repository;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.service.UserSerivce;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest extends BaseTest {

    UserRepository userRepository = UserRepository.instance();
    UserSerivce userSerivce = new UserSerivce();

    @Test
    public void should_return_user_object_when_given_exist_username() {
        User excepted = new User(1, "001-0001", "123456");

        User actual = userRepository.queryByUsername("001-0001");

        assertEquals(excepted, actual);
    }

    @Test
    public void should_getLoginedUser_return_logined_user_object_when_user_has_login() {
        User excepted = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");

        userSerivce.login("001-0001", "123456");
        User actual = userRepository.getLoginedUser();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_getLoginedUser_return_null_object_when_user_has_not_login() {
        User excepted = null;

        User actual = userRepository.getLoginedUser();

        assertEquals(excepted, actual);
    }

}

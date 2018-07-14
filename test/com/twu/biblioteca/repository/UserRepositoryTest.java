package com.twu.biblioteca.repository;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest extends BaseTest {

    UserRepository userRepository = UserRepository.instance();

    @Test
    public void should_return_user_object_when_given_exist_username() {
        User excepted = new User(1, "001-0001", "123456");

        User actual = userRepository.queryByUsername("001-0001");

        assertEquals(excepted, actual);
    }

}

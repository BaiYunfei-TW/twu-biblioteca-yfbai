package com.twu.biblioteca.entity;

import com.twu.biblioteca.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest extends BaseTest {

    @Test
    public void should_return_true_when_use_equals_to_compare_two_users_with_same_id_username_and_password() {
        User userA = new User(1, "001-0001", "123456");
        User userB = new User(1, "001-0001", "123456");

        boolean excepted = true;
        boolean actual = userA.equals(userB);

        assertEquals(excepted, actual);
    }

    @Test
    public void test_getInfo_should_return_user_s_information() {
        User userA = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");

        String excepted =   "Id: 1\r\n" +
                            "Account: 001-0001\r\n" +
                            "Name: yfbai\r\n" +
                            "Email: baiyunfeiii@foxmail.com\r\n" +
                            "Tel: 15626299517\r\n";

        assertEquals(excepted, userA.getInfo());
    }

}

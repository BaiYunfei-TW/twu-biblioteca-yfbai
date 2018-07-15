package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckoutRecordRepositoryTest {

    CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    @Test
    public void should_return_checkout_but_not_returned_list() {
        List<CheckoutRecord> excepted = Arrays.asList(
                new CheckoutRecord(
                        2,
                        new Book(3, "Design Patterns", "Erich Gamma", 2001, Book.STATE_CHECKED_OUT),
                        new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517")
                )
        );

        List<CheckoutRecord> checkoutRecordList = checkoutRecordRepository.checkoutButNotReturnedList();

        assertEquals(excepted, checkoutRecordList);
    }
}

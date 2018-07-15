package com.twu.biblioteca.serivce;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Checkable;
import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.CheckoutRecordRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReturnServiceTest extends BaseTest {

    CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    ReturnService returnService = new ReturnService();

    @Test
    public void test_return_books_and_the_book_is_checkable_again() {
        loginByManager();

        CheckoutRecord checkoutRecord = checkoutRecordRepository.checkoutButNotReturnedList().get(0);
        Checkable item = checkoutRecord.getItem();
        assertEquals(false, item.checkable());

        int state = returnService.returnItem(item.name());

        assertEquals(ReturnService.STATE_RETURN_SUCCESS, state);

        Book book = BookRepository.instance().queryByName("Head First Java");

        assertEquals(true, book.checkable());

        assertEquals(true, checkoutRecord.isReturned());
        assertEquals(true, checkoutRecord.getReturnTime()!=null);
    }

}

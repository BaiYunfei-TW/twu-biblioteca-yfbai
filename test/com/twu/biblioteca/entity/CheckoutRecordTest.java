package com.twu.biblioteca.entity;

import com.twu.biblioteca.BaseTest;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class CheckoutRecordTest extends BaseTest {

    @Test
    public void should_return_record_info_when_checked_out_and_then_returned() {
        String excepted = "Movie | Superman.Henry.2001 | 2018-01-01 10:00:00 | 2018-02-01 10:00:00 | 001-0001 | yfbai | baiyunfeiii@foxmail.com | 15626299517";

        Movie movie = new Movie(1, "Superman", 2001, "Henry", "9.1");
        User user = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");

        CheckoutRecord record = new CheckoutRecord(movie, user);
        record.setCheckoutTime(new GregorianCalendar(2018, Calendar.JANUARY,1,10,0,0).getTime());
        record.setReturnTime(new GregorianCalendar(2018,Calendar.FEBRUARY,1,10,0,0).getTime());

        assertEquals(excepted, record.toString());
    }

    @Test
    public void should_return_record_info_when_checked_out_but_not_returned() {
        String excepted = "Movie | Superman.Henry.2001 | 2018-01-01 10:00:00 | - | 001-0001 | yfbai | baiyunfeiii@foxmail.com | 15626299517";

        Movie movie = new Movie(1, "Superman", 2001, "Henry", "9.1");
        User user = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");

        CheckoutRecord record = new CheckoutRecord(movie, user);
        record.setCheckoutTime(new GregorianCalendar(2018, Calendar.JANUARY,1,10,0,0).getTime());

        assertEquals(excepted, record.toString());
    }

    @Test
    public void should_isReturned_return_false_when_the_item_has_not_been_returned() {
        boolean excepted = false;

        Movie movie = new Movie(1, "Superman", 2001, "Henry", "9.1");
        User user = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");

        CheckoutRecord record = new CheckoutRecord(movie, user);

        assertEquals(excepted, record.isReturned());

    }

    @Test
    public void should_isReturned_return_true_when_the_item_has_been_returned() {
        boolean excepted = true;

        Movie movie = new Movie(1, "Superman", 2001, "Henry", "9.1");
        User user = new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517");

        CheckoutRecord record = new CheckoutRecord(movie, user);
        record.returned();

        assertEquals(excepted, record.isReturned());

    }
}

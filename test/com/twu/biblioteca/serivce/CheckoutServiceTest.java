package com.twu.biblioteca.serivce;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repository.CheckoutRecordRepository;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class CheckoutServiceTest extends BaseTest {

    CheckoutService checkoutService = new CheckoutService();
    CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    @Test
    public void should_checkout_success_given_item_which_is_in_library() {
        login();

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1");
        int state = checkoutService.checkout(movie.getName());
        assertEquals(CheckoutService.STATE_CHECKOUT_SUCCESS, state);

        CheckoutRecord checkoutRecord = new CheckoutRecord(3, movie, UserRepository.instance().getLoginedUser());

        assertEquals(true, checkoutRecordRepository.checkoutButNotReturnedList().contains(checkoutRecord));
    }

    @Test
    public void should_checkout_failure_given_item_which_is_not_exist() {
        login();

        Movie movie = new Movie(1, "Superman2", 2005, "Henry", "9.1");
        int state = checkoutService.checkout(movie.getName());
        assertEquals(CheckoutService.STATE_CHECKOUT_FAILURE_NOT_EXIST, state);

        CheckoutRecord checkoutRecord = new CheckoutRecord(3, movie, UserRepository.instance().getLoginedUser());

        assertThat(CheckoutRecordRepository.instance().checkoutButNotReturnedList(), not(hasItem(checkoutRecord)));
    }

    @Test
    public void should_checkout_failure_given_item_which_is_checked_out() {
        login();

        Movie movie = new Movie(1, "Superman", 2005, "Henry", "9.1");
        checkoutService.checkout(movie.getName());

        int state = checkoutService.checkout(movie.getName());
        assertEquals(CheckoutService.STATE_CHECKOUT_FAILURE_NOT_IN_LIBRARY, state);

        CheckoutRecord checkoutRecord = new CheckoutRecord(4, movie, UserRepository.instance().getLoginedUser());

        assertEquals(false, checkoutRecordRepository.checkoutButNotReturnedList().contains(checkoutRecord));
    }
}

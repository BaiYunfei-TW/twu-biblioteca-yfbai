package com.twu.biblioteca.serivce;

import com.twu.biblioteca.entity.Checkable;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.CheckoutRecordRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;

public class CheckoutService {
    public static final int STATE_CHECKOUT_SUCCESS = 201;
    public static final int STATE_CHECKOUT_FAILURE_NOT_EXIST = 503;
    public static final int STATE_CHECKOUT_FAILURE_NOT_IN_LIBRARY = 502;
    public static final int STATE_NO_LOGIN = 501;

    private UserRepository userRepository = UserRepository.instance();
    private BookRepository bookRepository = BookRepository.instance();
    private MovieRepository movieRepository = MovieRepository.instance();
    private CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    public int checkout(String name) {
        if (!UserRepository.instance().isLogin()) {
            return STATE_NO_LOGIN;
        }
        Checkable item = bookRepository.queryByName(name);
        if (item == null) {
            item = movieRepository.queryByName(name);
        }
        if (item == null) {
            return STATE_CHECKOUT_FAILURE_NOT_EXIST;
        }
        if (!item.checkable()) {
            return STATE_CHECKOUT_FAILURE_NOT_IN_LIBRARY;
        }

        checkoutRecordRepository.createAndSave(item, userRepository.getLoginedUser());
        item.checkout();

        return STATE_CHECKOUT_SUCCESS;
    }
}

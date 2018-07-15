package com.twu.biblioteca.serivce;

import com.twu.biblioteca.entity.Checkable;
import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.CheckoutRecordRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;

public class ReturnService {

    public static final int STATE_RETURN_FAILURE_NO_LOGIN = 501;
    public static final int STATE_RETURN_FAILURE_NOT_EXIST = 503;
    public static final int STATE_RETURN_FAILURE_ALREADY_RETURNED = 502;
    public static final int STATE_RETURN_SUCCESS = 201;
    public static final int STATE_RETURN_FAILURE_YOU_ARE_NOT_OWNER = 504;

    private BookRepository bookRepository = BookRepository.instance();
    private MovieRepository movieRepository = MovieRepository.instance();
    private UserRepository userRepository = UserRepository.instance();
    private CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    public int returnItem(String name) {
        Checkable item = bookRepository.queryByName(name);
        User user = userRepository.getLoginedUser();
        if (user == null) {
            return STATE_RETURN_FAILURE_NO_LOGIN;
        }
        if (item == null) {
            item = movieRepository.queryByName(name);
        }
        if (item == null) {
            return STATE_RETURN_FAILURE_NOT_EXIST;
        }
        if (item.checkable()) {
            return STATE_RETURN_FAILURE_ALREADY_RETURNED;
        }
        CheckoutRecord checkoutRecord = checkoutRecordRepository.queryByItemIdAndUserId(item.getId(), user.getId());

        if (checkoutRecord == null) {
            return STATE_RETURN_FAILURE_YOU_ARE_NOT_OWNER;
        }

        checkoutRecord.returnToLibrary();
        item.returnToLibrary();

        return STATE_RETURN_SUCCESS;
    }
}

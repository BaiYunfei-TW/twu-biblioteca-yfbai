package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutMenuTest extends BaseTest {

    @Test
    public void should_check_out_the_book_when_it_has_not_been_checked_out_after_login() throws IOException {
        String excepted =   "Please login:\r\n" +
                            "Successfully login!\r\n" +
                            "----------------------------\r\n" +
                            "Successfully checked out!\r\n" +
                            "----------------------------\r\n";

        Book book = BookRepository.instance().queryByName("Head First Java");

        InputCommand inputCommand = mock(InputCommand.class);

        when(inputCommand.input("Please input the Book&Movie's name:\r\n")).thenReturn("Head First Java");
        when(inputCommand.input("Account:\r\n")).thenReturn("001-0001");
        when(inputCommand.input("Password:\r\n")).thenReturn("123456");

        new CheckOutMenu(inputCommand).enter();

        assertEquals(false, book.checkable());
        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_check_out_the_book_when_given_a_book_name_which_has_been_checked_out() throws IOException {
        login();

        String excepted =   "Sorry! \"Head First Java\" has been checked out!\r\n" +
                            "----------------------------\r\n";

        Book book = BookRepository.instance().queryByName("Head First Java");
        book.checkout();

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the Book&Movie's name:\r\n")).thenReturn("Head First Java");

        new CheckOutMenu(inputCommand).enter();

        assertEquals(false, book.checkable());
        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_check_out_the_book_when_given_a_book_name_which_is_not_in_repository() throws IOException {
        login();

        String excepted =   "Sorry! \"Introduction to Java\" is not in our library!\r\n" +
                            "----------------------------\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the Book&Movie's name:\r\n")).thenReturn("Introduction to Java");

        new CheckOutMenu(inputCommand).enter();

        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_user() {
        login();

        boolean actual = new CheckOutMenu(inputCommand).auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_after_login_by_manager() {
        login();

        boolean actual = new CheckOutMenu(inputCommand).auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_true_when_require_authorization_before_login() {
        login();

        boolean actual = new CheckOutMenu(inputCommand).auth(UserRepository.instance().getLoginedUser());
        boolean excepted = true;

        assertEquals(excepted, actual);
    }

}

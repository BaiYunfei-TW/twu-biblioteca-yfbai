package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckOutMenuTest extends BaseTest {

    @Test
    public void should_check_out_the_book_when_given_a_book_name_which_has_not_been_checked_out() throws IOException {
        String excepted =   "Successfully checked out!\r\n" +
                            "----------------------------\r\n";

        Book book = BookRepository.instance().queryByName("Head First Java");

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the book name:\r\n")).thenReturn("Head First Java");

        new CheckOutMenu(inputCommand).enter();

        assertEquals(false, book.checkable());
        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_check_out_the_book_when_given_a_book_name_which_has_been_checked_out() throws IOException {
        String excepted =   "Sorry! \"Head First Java\" has been checked out!\r\n" +
                            "----------------------------\r\n";

        Book book = BookRepository.instance().queryByName("Head First Java");
        book.checkout();

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the book name:\r\n")).thenReturn("Head First Java");

        new CheckOutMenu(inputCommand).enter();

        assertEquals(false, book.checkable());
        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_check_out_the_book_when_given_a_book_name_which_is_not_in_repository() throws IOException {
        String excepted =   "Sorry! \"Introduction to Java\" is not in our library!\r\n" +
                            "----------------------------\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the book name:\r\n")).thenReturn("Introduction to Java");

        new CheckOutMenu(inputCommand).enter();

        assertEquals(excepted, printedContent());
    }

}

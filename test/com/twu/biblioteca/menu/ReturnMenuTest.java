package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnMenuTest extends BaseTest {

    @Test
    public void should_the_book_checkable_when_given_a_book_name_which_has_been_checked_out_after_login() throws IOException {

        String excepted =   "Please login:\r\n" +
                            "Successfully login!\r\n" +
                            "----------------------------\r\n" +
                            "Successfully returned!\r\n" +
                            "----------------------------\r\n";

        Book book = BookRepository.instance().queryByName("Design Patterns");
        assertEquals(false, book.checkable());

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the book's name:\r\n")).thenReturn("Design Patterns");
        when(inputCommand.input("Account:\r\n")).thenReturn("001-0001");
        when(inputCommand.input("Password:\r\n")).thenReturn("123456");

        new ReturnMenu(inputCommand).enter();

        assertEquals(true, book.checkable());
        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_return_error_message_when_the_book_name_has_not_been_checked_out() throws IOException {
        login();
        String excepted =   "Sorry! \"Head First Java\" is already in our library!\r\n" +
                "----------------------------\r\n";

        Book book = BookRepository.instance().queryByName("Head First Java");

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the book's name:\r\n")).thenReturn("Head First Java");

        new ReturnMenu(inputCommand).enter();

        assertEquals(true, book.checkable());
        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_print_error_message_when_the_book_is_not_in_repository() throws IOException {
        login();
        String excepted =   "Sorry! \"Introduction to Java\" is not our book!\r\n" +
                "----------------------------\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input("Please input the book's name:\r\n")).thenReturn("Introduction to Java");

        new ReturnMenu(inputCommand).enter();

        assertEquals(excepted, printedContent());
    }

}

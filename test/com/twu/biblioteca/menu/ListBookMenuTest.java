package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListBookMenuTest extends BaseTest {

    private ListBookMenu listBookMenu = new ListBookMenu();

    @Test
    public void should_print_checkable_book_list_when_enter() {
        String excepted =   "Book List:\r\n" +
                            "----------------------------\r\n" +
                            "1. Head First Java | Bert Bates, Kathy Sierra | 2005\r\n" +
                            "2. Thinking in Java | Bruce Eckel | 2006\r\n" +
                            "----------------------------\r\n";
        listBookMenu.enter();

        assertEquals(excepted, printedContent());
    }

}

package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutRecordMenuTest extends BaseTest {

    @Test
    public void should_print_checked_out_records() {
        String excepted = "Type | Item details | Checkout Time | Return Time |Account | Name | Email | Tel\r\n" +
                "----------------------------\r\n" +
                "Book | Design Patterns.Erich Gamma.2001 | 2018-01-01 10:00:00 | - | 001-0001 | yfbai | baiyunfeiii@foxmail.com | 15626299517\r\n" +
                "----------------------------\r\n";

        CheckoutRecordMenu checkoutRecordMenu = new CheckoutRecordMenu();
        checkoutRecordMenu.enter();

        assertEquals(excepted, printedContent());
    }
}

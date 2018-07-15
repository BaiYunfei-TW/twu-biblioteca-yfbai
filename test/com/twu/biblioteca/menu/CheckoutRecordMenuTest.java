package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.repository.CheckoutRecordRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutRecordMenuTest extends BaseTest {

    CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    @Test
    public void should_print_checked_out_records() {
        String excepted = "Type | Item details | Checkout Time | Return Time |Account | Name | Email | Tel\r\n" +
                "----------------------------\r\n";
        for (CheckoutRecord record :
                checkoutRecordRepository.checkoutButNotReturnedList()) {
            excepted += record.toString() + "\r\n";
        }
        excepted += "----------------------------\r\n";

        CheckoutRecordMenu checkoutRecordMenu = new CheckoutRecordMenu();
        checkoutRecordMenu.enter();

        assertEquals(excepted, printedContent());
    }
}

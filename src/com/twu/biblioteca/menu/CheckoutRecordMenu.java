package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.CheckoutRecordRepository;

public class CheckoutRecordMenu implements Menu{

    CheckoutRecordRepository checkoutRecordRepository = CheckoutRecordRepository.instance();

    @Override
    public int enter() {
        System.out.println("Type | Item details | Checkout Time | Return Time |Account | Name | Email | Tel");
        System.out.println("----------------------------");
        for (CheckoutRecord record :
                checkoutRecordRepository.checkoutButNotReturnedList()) {
            System.out.println(record.toString());
        }
        System.out.println("----------------------------");
        return 0;
    }

    @Override
    public String title() {
        return "Checkout Records";
    }

    @Override
    public boolean auth(User user) {
        return user != null && User.ROLE_MANAGER.equals(user.getRole());
    }
}

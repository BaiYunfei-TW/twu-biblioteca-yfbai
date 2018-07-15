package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Checkable;
import com.twu.biblioteca.entity.CheckoutRecord;
import com.twu.biblioteca.entity.User;

import java.util.*;

public class CheckoutRecordRepository {

    private static final CheckoutRecordRepository checkoutRecordRepository;

    private List<CheckoutRecord> checkoutRecordList;

    static {
        checkoutRecordRepository = new CheckoutRecordRepository();
    }

    private CheckoutRecordRepository() {
        init();
    }

    public static CheckoutRecordRepository instance() {
        return checkoutRecordRepository;
    }

    public void init() {
        checkoutRecordList = new ArrayList<>(Arrays.asList(
                new CheckoutRecord(
                        1,
                        BookRepository.instance().queryByName("Head First Java"),
                        UserRepository.instance().queryByUsername("001-0001"),
                        CheckoutRecord.STATE_RETURNED
                ).setCheckoutTime(new GregorianCalendar(2017, Calendar.DECEMBER,1,10,0,0).getTime())
                        .setReturnTime(new GregorianCalendar(2017, Calendar.DECEMBER,1,10,0,0).getTime()),
                new CheckoutRecord(
                        2,
                        BookRepository.instance().queryByName("Design Patterns"),
                        UserRepository.instance().queryByUsername("001-0001")
                ).setCheckoutTime(new GregorianCalendar(2018, Calendar.JANUARY,1,10,0,0).getTime())
        ));
    }

    public List<CheckoutRecord> checkoutButNotReturnedList() {
        List<CheckoutRecord> records = new ArrayList<>();
        for (CheckoutRecord r :
                this.checkoutRecordList) {
            if (!r.isReturned()) {
                records.add(r);
            }
        }
        return records;
    }

    public void createAndSave(Checkable item, User user) {
        int id = checkoutRecordList.get(checkoutRecordList.size()-1).getId()+1;
        CheckoutRecord checkoutRecord = new CheckoutRecord(id, item, user);
        checkoutRecordList.add(checkoutRecord);
    }

    public CheckoutRecord queryByItemIdAndUserId(int itemId, int userId) {
        for (CheckoutRecord record :
                checkoutRecordList) {
            if (record.getItem().getId() == itemId && record.getUser().getId() == userId) {
                return record;
            }
        }
        return null;
    }
}

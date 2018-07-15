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
                        new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005),
                        new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517"),
                        CheckoutRecord.STATE_RETURNED
                ).setCheckoutTime(new GregorianCalendar(2017, Calendar.DECEMBER,1,10,0,0).getTime())
                .setReturnTime(new GregorianCalendar(2017, Calendar.DECEMBER,1,10,0,0).getTime()),
                new CheckoutRecord(
                        2,
                        new Book(3, "Design Patterns", "Erich Gamma", 2001, Book.STATE_CHECKED_OUT),
                        new User(1, "001-0001", "123456", "yfbai", "baiyunfeiii@foxmail.com", "15626299517")
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
}

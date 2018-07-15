package com.twu.biblioteca.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutRecord {

    private int id;

    private Checkable item;
    private User user;

    private Date checkoutTime;
    private Date returnTime;

    private String state;

    public static final String STATE_RETURNED = "returned";
    public static final String STATE_CHECKOUT = "checkout";

    public CheckoutRecord(Checkable item, User user) {
        this(-1, item, user);
    }

    public CheckoutRecord(int id, Checkable item, User user) {
        this(id, item, user, new Date(), null, STATE_CHECKOUT);
    }

    public CheckoutRecord(int id, Checkable item, User user, String state) {
        this.id = id;
        this.item = item;
        this.user = user;
        this.state = state;
    }

    public CheckoutRecord(int id, Checkable item, User user, Date checkoutTime, Date returnTime, String state) {
        this.id = id;
        this.item = item;
        this.user = user;
        this.checkoutTime = checkoutTime;
        this.returnTime = returnTime;
        this.state = state;
    }

    public CheckoutRecord setCheckoutTime(Date date) {
        this.checkoutTime = date;
        return this;
    }

    public CheckoutRecord setReturnTime(Date date) {
        this.returnTime = date;
        return this;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String checkoutTime = this.checkoutTime != null ? dateFormat.format(this.checkoutTime) : "-";
        String returnTime = this.returnTime != null ? dateFormat.format(this.returnTime) : "-";

        return String.format("%s | %s | %s | %s | %s | %s | %s | %s",
                item.type(),
                item.info(),
                checkoutTime,
                returnTime,
                user.getAccount(),
                user.getName(),
                user.getEmail(),
                user.getTel());
    }

    public boolean isReturned() {
        return STATE_RETURNED.equals(this.state);
    }

    public void returned() {
        this.state = STATE_RETURNED;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CheckoutRecord)) {
            return false;
        }
        return id == ((CheckoutRecord) obj).id;
    }

    public int getId() {
        return id;
    }
}

package com.twu.biblioteca.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void should_return_true_when_the_book_is_in_library() {
        boolean excepted = true;

        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005);
        boolean actual = book.checkable();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_false_when_the_book_is_already_checked_out() {
        boolean excepted = false;

        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005, Book.STATE_CHECKED_OUT);
        boolean actual = book.checkable();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_false_after_checking_out_the_book() {
        boolean excepted = false;

        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005);
        book.checkout();
        boolean actual = book.checkable();

        assertEquals(excepted, actual);
    }

    @Test
    public void should_toString_return_book_details() {
        String excepted = "1. Head First Java | Bert Bates, Kathy Sierra | 2005";

        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005);

        assertEquals(excepted, book.toString());
    }

    @Test
    public void should_checkable_return_true_when_a_book_was_returned() {
        boolean excepted = true;

        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005, Book.STATE_CHECKED_OUT);
        book.returnToLibrary();

        assertEquals(excepted, book.checkable());
    }

    @Test
    public void should_return_book_type() {
        String excepted = "Book";
        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005, Book.STATE_CHECKED_OUT);

        assertEquals(excepted, book.type());
    }

    @Test
    public void should_return_book_info() {
        String excepted = "Head First Java.Bert Bates, Kathy Sierra.2005";
        Book book = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005, Book.STATE_CHECKED_OUT);

        assertEquals(excepted, book.info());
    }

}

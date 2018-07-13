package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {

    private static final BookRepository bookRepository;

    private List<Book> bookList;

    static {
        bookRepository = new BookRepository();
    }

    private BookRepository() {
        this.bookList = Arrays.asList(new Book(1,"Head First Java", "Bert Bates, Kathy Sierra", 2005, Book.STATE_IN_LIBRARY),
                new Book(2, "Thinking in Java", "Bruce Eckel", 2006, Book.STATE_IN_LIBRARY),
                new Book(3, "Design Patterns", "Erich Gamma", 2001, Book.STATE_CHECKED_OUT));
    }

    public void init() {
        this.bookList = Arrays.asList(new Book(1,"Head First Java", "Bert Bates, Kathy Sierra", 2005, Book.STATE_IN_LIBRARY),
                new Book(2, "Thinking in Java", "Bruce Eckel", 2006, Book.STATE_IN_LIBRARY),
                new Book(3, "Design Patterns", "Erich Gamma", 2001, Book.STATE_CHECKED_OUT));
    }

    /**
     * Return books which could be checked out
     * @return
     */
    public List<Book> getCheckableBooks() {
        List<Book> checkableBooks = new ArrayList<>();
        for (Book book :
                bookList) {
            if (book.checkable()) {
                checkableBooks.add(book);
            }
        }
        return checkableBooks;
    }

    public static BookRepository instance() {
        return bookRepository;
    }

    public Book queryByName(String name) {
        for (Book book : bookList) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }
}

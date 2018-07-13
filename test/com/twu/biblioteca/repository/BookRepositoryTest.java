package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @Before
    public void init() {
        this.bookRepository = BookRepository.instance();
    }

    @Test
    public void should_return_checkable_book_list_after_initialize() {
        List<Book> actual = bookRepository.getCheckableBooks();

        List<Book> excepted = Arrays.asList(
                new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005),
                new Book(2, "Thinking in Java", "Bruce Eckel", 2006));

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_right_book_object_when_query_by_book_name_exist_in_repository() {
        Book excepted = new Book(1, "Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book actual = bookRepository.queryByName("Head First Java");

        assertEquals(excepted, actual);
    }

    @Test
    public void should_return_null_when_query_by_book_name_not_exists_in_repository() {
        Book excepted = null;
        Book actual = bookRepository.queryByName("Head First Python");

        assertEquals(excepted, actual);
    }

}

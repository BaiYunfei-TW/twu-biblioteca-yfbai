package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;

public class ListBookMenu implements Menu {
    @Override
    public void enter() {
        System.out.println("Book List:");
        System.out.println("----------------------------");
        for (Book book :
                BookRepository.instance().getCheckableBooks()) {
            System.out.println(book.toString());
        }
        System.out.println("----------------------------");
    }

}
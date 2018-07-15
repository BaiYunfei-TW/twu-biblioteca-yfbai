package com.twu.biblioteca.menu;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.BookRepository;

public class ListBookMenu implements Menu {
    @Override
    public int enter() {
        System.out.println("Book List:");
        System.out.println("----------------------------");
        for (Book book :
                BookRepository.instance().getCheckableBooks()) {
            System.out.println(book.toString());
        }
        System.out.println("----------------------------");
        return 0;
    }

    @Override
    public String title() {
        return "List Books";
    }

    @Override
    public boolean auth(User user) {
        return true;
    }
}

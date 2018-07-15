package com.twu.biblioteca;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.service.UserSerivce;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BaseTest {

    protected ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    protected InputCommand inputCommand = new InputCommand();
    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));

        BookRepository.instance().init();
        UserRepository.instance().init();
    }

    public String printedContent() {
        return outContent.toString();
    }

    protected String input(String message) throws IOException {
        return inputCommand.input(message);
    }

    protected void login() {
        UserSerivce userSerivce = new UserSerivce();
        userSerivce.login("001-0001", "123456");
    }
}

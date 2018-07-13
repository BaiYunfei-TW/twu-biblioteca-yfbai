package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class BibliotecaAppTest extends BaseTest {

    private BibliotecaApp app = new BibliotecaApp();

    @Test
    public void should_print_welcome_message_and_menu_when_the_application_start() {
        String expected =   "Hello! Welcome to Biblioteca\r\n" +
                            "----------------------------\r\n" +
                            "Menu:\r\n" +
                            "1. List Books\r\n" +
                            "2. Checkout Books\r\n" +
                            "3. Return Books\r\n" +
                            "0. Quit\r\n" +
                            "----------------------------\r\n";
        app.start();

        assertEquals(expected, printedContent());
    }

}

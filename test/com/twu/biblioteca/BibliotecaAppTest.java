package com.twu.biblioteca;

import com.twu.biblioteca.commands.InputCommand;
import com.twu.biblioteca.menu.MainMenu;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest extends BaseTest {

    private BibliotecaApp app = new BibliotecaApp();

    @Test
    public void should_print_welcome_message_and_menu_when_the_application_start() throws IOException {
        String excepted =   "1. List Books\r\n" +
                "2. List Movies\r\n" +
                "3. Checkout\r\n" +
                "4. Return\r\n" +
                "9. Login\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Bye\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input(">")).thenReturn("0");

        app.start(inputCommand);

        assertEquals(excepted, printedContent());
    }

}

package com.twu.biblioteca.menu;

import com.twu.biblioteca.BaseTest;
import com.twu.biblioteca.commands.InputCommand;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainMenuTest extends BaseTest {

    @Test
    public void should_quit_when_select_0() throws IOException {
        String excepted =   "1. List Books\r\n" +
                            "2. Checkout Books\r\n" +
                            "3. Return Books\r\n" +
                            "0. Quit\r\n" +
                            "----------------------------\r\n" +
                            "Bye\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input(">")).thenReturn("0");
        MainMenu mainMenu = new MainMenu(inputCommand);
        mainMenu.enter();

        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_enter_ListBook_menu_and_then_quit_when_select_1_and_then_0() throws IOException {
        String excepted =   "1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Book List:\r\n" +
                "----------------------------\r\n" +
                "1. Head First Java | Bert Bates, Kathy Sierra | 2005\r\n" +
                "2. Thinking in Java | Bruce Eckel | 2006\r\n" +
                "----------------------------\r\n" +
                "1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Bye\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input(">")).thenReturn("1","0");
        MainMenu mainMenu = new MainMenu(inputCommand);
        mainMenu.enter();

        assertEquals(excepted, printedContent());
    }

}

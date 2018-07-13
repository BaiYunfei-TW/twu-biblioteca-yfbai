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

    @Test
    public void should_enter_Checkout_menu_and_checkout_book_and_then_quit_when_given_2_and_Head_First_Java_and_then_0() throws IOException {
        String excepted =   "1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Successfully checked out!\r\n" +
                "----------------------------\r\n" +
                "1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Bye\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input(">")).thenReturn("2","0");
        when(inputCommand.input("Please input the book name:\r\n")).thenReturn("Head First Java");
        MainMenu mainMenu = new MainMenu(inputCommand);
        mainMenu.enter();

        assertEquals(excepted, printedContent());
    }

    @Test
    public void should_enter_Return_menu_and_return_the_book_named_Design_Patterns_when_given_3_and_Design_Pattern() throws IOException {
        String excepted =   "1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Successfully returned!\r\n" +
                "----------------------------\r\n" +
                "1. List Books\r\n" +
                "2. Checkout Books\r\n" +
                "3. Return Books\r\n" +
                "0. Quit\r\n" +
                "----------------------------\r\n" +
                "Bye\r\n";

        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input(">")).thenReturn("3","0");
        when(inputCommand.input("Please input the book's name:\r\n")).thenReturn("Design Patterns");
        MainMenu mainMenu = new MainMenu(inputCommand);
        mainMenu.enter();

        assertEquals(excepted, printedContent());
    }

}

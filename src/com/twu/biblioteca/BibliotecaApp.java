package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void start() {
        final String startMessage = "Hello! Welcome to Biblioteca\r\n" +
                                    "----------------------------\r\n" +
                                    "Menu:\r\n" +
                                    "1. List Books\r\n" +
                                    "2. Checkout Books\r\n" +
                                    "3. Return Books\r\n" +
                                    "0. Quit\r\n" +
                                    "----------------------------\r\n";
        System.out.print(startMessage);
    }
}

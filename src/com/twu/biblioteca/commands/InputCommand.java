package com.twu.biblioteca.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputCommand {

    private BufferedReader bufferedReader;

    public InputCommand(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String input(String message) throws IOException {
        System.out.print(message);
        return bufferedReader.readLine();
    }
}

package org.example.view.reader;

import java.util.Scanner;

public class KeyboardReader implements Reader {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String input() {
        return scanner.next();
    }
}

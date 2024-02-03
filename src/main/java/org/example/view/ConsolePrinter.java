package org.example.view;

public class ConsolePrinter implements Printer{
    @Override
    public void out(String text) {
        System.out.println(text);
    }
}

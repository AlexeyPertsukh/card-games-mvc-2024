package org.example.common.view.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void output(String text) {
        System.out.println(text);
    }

    @Override
    public void output() {
        output("");
    }

    @Override
    public void out(String text) {
        System.out.print(text);
    }
}

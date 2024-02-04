package org.example.view.views.printer;

import org.example.view.views.printer.Printer;

public class ConsolePrinter implements Printer {
    @Override
    public void output(String text) {
        System.out.println(text);
    }

    @Override
    public void out(String text) {
        System.out.print(text);
    }
}

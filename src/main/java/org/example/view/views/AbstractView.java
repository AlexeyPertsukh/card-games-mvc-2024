package org.example.view.views;

import org.example.view.views.printer.Printer;

public abstract class AbstractView<T> implements View<T>{
    protected final Printer printer;

    public AbstractView(Printer printer) {
        this.printer = printer;
    }
}

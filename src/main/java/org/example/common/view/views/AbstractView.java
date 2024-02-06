package org.example.common.view.views;

import org.example.common.view.printer.Printer;

public abstract class AbstractView<T> implements View {

    protected final T value;
    protected final Printer printer;

    public AbstractView(T value, Printer printer) {
        this.printer = printer;
        this.value = value;
    }
}

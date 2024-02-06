package org.example.common.view.dialog_view;

import org.example.common.view.reader.Reader;
import org.example.common.view.printer.Printer;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractDialogView<T> implements DialogView<T> {
    private final Printer printer;
    private final Reader reader;
    private final String tittle;
    private final String errorMessage;
    private final Predicate<String> predicate;
    private final Function<String, T> mapper;

    public AbstractDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Predicate<String> predicate, Function<String, T> mapper) {
        this.printer = printer;
        this.reader = reader;
        this.tittle = tittle;
        this.errorMessage = errorMessage;
        this.predicate = predicate;
        this.mapper = mapper;
    }


    @Override
    public T input() {
        while (true) {
            showTittle();
            String key = reader.input();
            if (predicate.test(key)) {
                return mapper.apply(key);
            }
            showErrorMessage();
        }
    }

    protected void showTittle() {
        printer.output(tittle);
    }

    protected void showErrorMessage() {
        printer.output(errorMessage);
    }
}

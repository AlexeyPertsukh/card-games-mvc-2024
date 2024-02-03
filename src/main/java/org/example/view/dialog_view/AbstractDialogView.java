package org.example.view.dialog_view;

import org.example.view.Printer;
import org.example.view.Reader;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractDialogView<T> implements DialogView<T> {
    private final Printer printer;
    private final Reader reader;
    private final String tittle;
    private final String errorMessage;
    private final Predicate<String> predicate;
    private final Function<String, T> map;

    public AbstractDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Predicate<String> predicate, Function<String, T> map) {
        this.printer = printer;
        this.reader = reader;
        this.tittle = tittle;
        this.errorMessage = errorMessage;
        this.predicate = predicate;
        this.map = map;
    }


    @Override
    public T input() {
        while (true) {
            printer.out(tittle);
            String key = reader.input();
            if (predicate.test(key)) {
                return map.apply(key);
            }
            printer.out(errorMessage);
        }
    }
}

package org.example.view.dialog_view;

import org.example.view.views.printer.Printer;
import org.example.view.views.reader.Reader;

import java.util.function.Predicate;

public class MinMaxIntegerDialogView extends IntegerDialogView {
    public MinMaxIntegerDialogView(Printer printer, Reader reader, String tittle, String errorMessage, int min, int max) {
        super(printer, reader, tittle, errorMessage, predicate(min, max));
    }

    private static Predicate<String> predicate(int min, int max) {
        return s -> isInteger(s) && min <= Integer.parseInt(s) && Integer.parseInt(s) <= max;
    }

}

package org.example.common.view.dialog_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.reader.Reader;

import java.util.function.Predicate;

public class MinMaxIntegerDialogView extends IntegerDialogView {
    public MinMaxIntegerDialogView(Printer printer, Reader reader, String tittle, String errorMessage, int min, int max) {
        super(printer, reader, tittle, errorMessage, predicate(min, max));
    }

    private static Predicate<String> predicate(int min, int max) {
        return s -> isInteger(s) && min <= Integer.parseInt(s) && Integer.parseInt(s) <= max;
    }

}

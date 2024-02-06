package org.example.common.view.dialog_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.reader.Reader;

import java.util.function.Predicate;

public class IntegerDialogView extends AbstractDialogView<Integer> {
    public IntegerDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Predicate<String> predicate) {
        super(printer, reader, tittle, errorMessage, predicate, Integer::parseInt);
    }

    protected static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package org.example.view.dialog_view;

import org.example.view.Printer;
import org.example.view.Reader;

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

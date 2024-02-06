package org.example.view.dialog_view;

import org.example.view.printer.Printer;
import org.example.view.reader.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SelectIntegerDialogView extends IntegerDialogView {
    public SelectIntegerDialogView(Printer printer, Reader reader, String tittle, String errorMessage, List<Integer> integers) {
        super(printer, reader, tittle, errorMessage, predicate(integers));
    }

    public SelectIntegerDialogView(Printer printer, Reader reader, String tittle, String errorMessage, int... integers) {
        this(printer, reader, tittle, errorMessage, list(integers));
    }

    private static List<Integer> list(int... integers) {
        List<Integer> list = new ArrayList<>();
        for (int num : integers) {
            list.add(num);
        }
        return list;
    }

    private static Predicate<String> predicate(List<Integer> integers) {
        return s -> isInteger(s) && integers.contains(Integer.parseInt(s));
    }
}

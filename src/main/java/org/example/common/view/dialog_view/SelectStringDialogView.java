package org.example.common.view.dialog_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.reader.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectStringDialogView extends StringDialogView{
    public SelectStringDialogView(Printer printer, Reader reader, String tittle, String errorMessage, List<String> strings) {
        super(printer, reader, tittle, errorMessage, strings::contains);
    }

    public SelectStringDialogView(Printer printer, Reader reader, String tittle, String errorMessage, String... strings) {
        this(printer, reader, tittle, errorMessage, list(strings));
    }

    private static List<String> list(String... strings) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        return list;
    }

}

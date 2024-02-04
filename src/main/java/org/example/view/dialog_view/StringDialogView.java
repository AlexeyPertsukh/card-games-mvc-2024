package org.example.view.dialog_view;

import org.example.view.views.printer.Printer;
import org.example.view.views.reader.Reader;

import java.util.function.Predicate;

public class StringDialogView extends AbstractDialogView<String>{
    public StringDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Predicate<String> predicate) {
        super(printer, reader, tittle, errorMessage, predicate, s -> s);
    }
}

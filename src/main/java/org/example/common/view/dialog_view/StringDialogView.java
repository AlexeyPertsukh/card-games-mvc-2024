package org.example.common.view.dialog_view;

import org.example.common.view.printer.Printer;
import org.example.common.view.reader.Reader;

import java.util.function.Predicate;

public class StringDialogView extends AbstractDialogView<String>{
    public StringDialogView(Printer printer, Reader reader, String tittle, String errorMessage, Predicate<String> predicate) {
        super(printer, reader, tittle, errorMessage, predicate, s -> s);
    }
}

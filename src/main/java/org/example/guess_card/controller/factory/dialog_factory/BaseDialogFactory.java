package org.example.guess_card.controller.factory.dialog_factory;

import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.SelectStringDialogView;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;

public class BaseDialogFactory extends AbstractDialogFactory{
    private final Printer printer = new ConsolePrinter();
    private final Reader reader = new KeyboardReader();

    @Override
    public DialogView<String> dialogStart() {
        String tittle = String.format(START_DIALOG_TEMPLATE, HELP_KEY, DEFAULT_CONTINUE_KEY);
        return dialogInput(tittle, HELP_KEY, DEFAULT_CONTINUE_KEY);
    }

    public DialogView<String> dialogInput(String tittle, String... keys) {
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                keys
        );
    }
}

package org.example.controller.factory;

import org.example.view.printer.Printer;
import org.example.view.reader.Reader;
import org.example.view.dialog_view.DialogView;
import org.example.view.dialog_view.SelectStringDialogView;

public class DialogFactory {
    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    private static final String BUST_MESSAGE_TEMPLATE = "[%s] is BUST, press '%s' to continue";
    private static final String BASIC_PRESS_TO_CONTINUE_TEMPLATE = "press '%s' to continue";
    private static final String DEFAULT_CONTINUE_KEY = "y";
    private final Printer printer;
    private final Reader reader;

    public DialogFactory(Printer printer, Reader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public DialogView<String> dialogStart() {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format("Press '%s' to start game", key);
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                "",
                key
        );
    }

    public DialogView<String> dialogBeginCardDealOver() {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format("Initial card deal is over, press '%s' to continue", key);
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                "",
                key
        );
    }

    public DialogView<String> playerInputDialog(String name, String keyTake, String keySkip) {
        String tittle = String.format("[%s] input command: %s - take card, %s - skip",
                name,
                keyTake,
                keySkip
        );
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                keyTake,
                keySkip
        );
    }

    public DialogView<String> dialogBust(String name) {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format(BUST_MESSAGE_TEMPLATE,
                name,
                key
        );
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                key
        );
    }

    //
    public DialogView<String> dialogPressToContinue() {
        String key = DEFAULT_CONTINUE_KEY;
        final String tittle = String.format(BASIC_PRESS_TO_CONTINUE_TEMPLATE, key);
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                key
        );
    }

}

package org.example.guess_card.controller.factory.dialog_factory;

import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.SelectStringDialogView;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.guess_card.controller.factory.bet_factory.BetFactory;

import java.util.ArrayList;
import java.util.List;

public class BaseDialogFactory extends AbstractDialogFactory {
    private final Printer printer = new ConsolePrinter();
    private final Reader reader = new KeyboardReader();

    @Override
    public DialogView<String> dialogStart() {
        String tittle = String.format(BASIC_PRESS_TO_CONTINUE_TEMPLATE, DEFAULT_CONTINUE_KEY);
        return dialogInput(tittle, DEFAULT_CONTINUE_KEY);
    }

    @Override
    public DialogView<String> dialogCommand(String name) {
        String tittle = String.format(INPUT_BET_TEMPLATE, name);
        String[] keysCommand = keysCommand();
        return dialogInput(tittle, keysCommand);
    }

    private String[] keysCommand() {
        List<String> list = new ArrayList<>();
        BetFactory.Key[] keys = BetFactory.Key.values();
        for (BetFactory.Key key : keys) {
            list.add(key.getCommand());
        }
        return list.toArray(new String[0]);
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

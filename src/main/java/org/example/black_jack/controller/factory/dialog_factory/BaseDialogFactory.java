package org.example.black_jack.controller.factory.dialog_factory;

import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.SelectStringDialogView;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;

public class BaseDialogFactory extends AbstractDialogFactory {
    private final Printer printer = new ConsolePrinter();
    private final Reader reader = new KeyboardReader();

    public BaseDialogFactory() {

    }

    @Override
    public DialogView<String> dialogStart() {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format("Press '%s' to start game", key);
        return dialogInput(tittle, key);
    }

    @Override
    public DialogView<String> dialogBeginCardDealOver() {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format("Initial card deal is over, press '%s' to continue", key);
        return dialogInput(tittle, key);
    }

    @Override
    public DialogView<String> dialogNotInGame(String name) {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format(BUST_MESSAGE_TEMPLATE,
                name,
                key
        );
        return dialogInput(tittle, key);
    }

    @Override
    public DialogView<String> dialogPlayerCmdInput(String name, String keyTake, String keySkip) {
        String tittle = String.format(DIALOG_INPUT_CMD_TEMPLATE,
                name,
                keyTake,
                keySkip
        );
        return dialogInput(tittle, keyTake, keySkip);
    }

    @Override
    public DialogView<String> dialogDealerRevealsCard(String name) {
        String key = DEFAULT_CONTINUE_KEY;
        final String tittle = String.format(DEALER_REVEALS_CARD_TEMPLATE, key);
        return dialogInput(tittle, key);
    }

    @Override
    public DialogView<String> dialogPressToContinue() {
        String key = DEFAULT_CONTINUE_KEY;
        final String tittle = String.format(BASIC_PRESS_TO_CONTINUE_TEMPLATE, key);
        return dialogInput(tittle, key);
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

    @Override
    public DialogView<String> dialogIsBot(String name) {
        String key = DEFAULT_CONTINUE_KEY;
        final String tittle = String.format(DIALOG_IS_BOT, name, key);
        return dialogInput(tittle, key);
    }
}

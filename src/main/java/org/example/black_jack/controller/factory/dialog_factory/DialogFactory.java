package org.example.black_jack.controller.factory.dialog_factory;

import org.example.common.view.dialog_view.DialogView;

public interface DialogFactory {
    DialogView<String> dialogStart();
    DialogView<String> dialogBeginCardDealOver();
    DialogView<String> dialogNotInGame(String name);
    DialogView<String> dialogIsBot(String name);
    DialogView<String> dialogPlayerCmdInput(String name, String keyTake, String keySkip);
    DialogView<String> dialogDealerRevealsCard(String name);
    DialogView<String> dialogPressToContinue();
}

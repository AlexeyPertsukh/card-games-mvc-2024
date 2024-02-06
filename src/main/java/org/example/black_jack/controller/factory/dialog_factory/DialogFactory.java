package org.example.black_jack.controller.factory.dialog_factory;

import org.example.common.view.dialog_view.DialogView;

public interface DialogFactory {
    DialogView<String> dialogStart();

    DialogView<String> dialogBeginCardDealOver();

    DialogView<String> dialogBust(String name);

    DialogView<String> dialogPlayerInput(String name, String keyTake, String keySkip);

    DialogView<String> dialogPressToContinue();
}

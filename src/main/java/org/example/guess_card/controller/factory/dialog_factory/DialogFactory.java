package org.example.guess_card.controller.factory.dialog_factory;

import org.example.common.view.dialog_view.DialogView;

public interface DialogFactory {
    DialogView<String> dialogStart();
    DialogView<String> dialogCommand(String name);

}

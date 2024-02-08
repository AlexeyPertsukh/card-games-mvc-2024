package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.common.view.dialog_view.DialogView;

public class StartState extends org.example.black_jack.controller.state.State {
    private final DialogFactory dialogFactory;
    private final ViewFactory viewFactory;
    public StartState(GameController controller) {
        super(controller);
        dialogFactory = controller.getDialogFactory();
        viewFactory = controller.getViewFactory();
    }

    @Override
    public void execute() {
        viewFactory.tittle().show();
        DialogView<String> dialog = dialogFactory.dialogStart();
        dialog.input();
    }
}

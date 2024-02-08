package org.example.black_jack.controller.game_controller.state;

import org.example.black_jack.controller.game_controller.GameController;
import org.example.common.view.dialog_view.DialogView;

public class StartState extends State {
    public StartState(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        viewFactory.tittle().show();
        DialogView<String> dialog = dialogFactory.dialogStart();
        dialog.input();
    }
}

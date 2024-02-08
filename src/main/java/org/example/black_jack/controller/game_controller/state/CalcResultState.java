package org.example.black_jack.controller.game_controller.state;

import org.example.black_jack.controller.game_controller.GameController;

public class CalcResultState extends State {


    public CalcResultState(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        viewFactory.infoGameResult().show();
        game.calculateResult();
        controller.showTable();
    }
}

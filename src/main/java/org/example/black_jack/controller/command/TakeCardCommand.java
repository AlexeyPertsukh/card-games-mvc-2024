package org.example.black_jack.controller.command;

import org.example.black_jack.controller.GameController;

public class TakeCardCommand extends GameControllerCommand {
    public final static String KEY = "t";
    public TakeCardCommand(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.takeCardCurrentPlayer();
    }

}

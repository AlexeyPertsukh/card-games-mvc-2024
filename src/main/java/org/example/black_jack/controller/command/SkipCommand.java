package org.example.black_jack.controller.command;

import org.example.black_jack.controller.GameController;

public class SkipCommand extends GameControllerCommand {
    public final static String KEY = "s";
    public SkipCommand(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
//        controller.skip();
    }

}

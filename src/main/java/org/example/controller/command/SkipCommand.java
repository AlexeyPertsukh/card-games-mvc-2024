package org.example.controller.command;

import org.example.controller.GameController;

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

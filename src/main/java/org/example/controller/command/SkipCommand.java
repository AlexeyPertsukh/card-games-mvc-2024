package org.example.controller.command;

import org.example.controller.GameController;
import org.example.model.game.Game;

public class SkipCommand extends GameControllerCommand {
    public final static String KEY = "s";
    public SkipCommand(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.skip();
    }

    @Override
    public String key() {
        return KEY;
    }
}

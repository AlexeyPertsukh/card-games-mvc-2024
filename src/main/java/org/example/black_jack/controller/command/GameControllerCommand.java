package org.example.black_jack.controller.command;

import org.example.black_jack.controller.GameController;

public abstract class GameControllerCommand implements Command{
    protected final GameController controller;

    public GameControllerCommand(GameController controller) {
        this.controller = controller;
    }
}

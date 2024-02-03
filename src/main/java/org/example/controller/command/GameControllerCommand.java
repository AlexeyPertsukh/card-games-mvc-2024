package org.example.controller.command;

import org.example.controller.GameController;

public abstract class GameControllerCommand implements Command{
    protected final GameController controller;

    public GameControllerCommand(GameController controller) {
        this.controller = controller;
    }
}

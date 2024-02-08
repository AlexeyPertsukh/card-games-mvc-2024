package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;

public abstract class State {
    protected final GameController controller;

    public State(GameController controller) {
        this.controller = controller;
    }

    public abstract void execute();
}

package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.model.game.Game;

public abstract class State {
    protected final GameController controller;
    protected final DialogFactory dialogFactory;
    protected final ViewFactory viewFactory;
    protected final Game game;

    public State(GameController controller) {
        this.controller = controller;
        dialogFactory = controller.getDialogFactory();
        viewFactory = controller.getViewFactory();
        game = controller.getGame();
    }

    public abstract void execute();
}

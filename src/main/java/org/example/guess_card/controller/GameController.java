package org.example.guess_card.controller;

import org.example.common.model.player.Player;
import org.example.guess_card.controller.factory.dialog_factory.DialogFactory;
import org.example.guess_card.controller.factory.view_factory.ViewFactory;
import org.example.guess_card.model.Game;

public class GameController {
    private final Game game;
    private final ViewFactory viewFactory;
    private final DialogFactory dialogFactory;

    public GameController(Game game, ViewFactory viewFactory, DialogFactory dialogFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
        this.dialogFactory = dialogFactory;
    }

    public void go() {
        viewFactory.tittle().show();
        dialogFactory.dialogStart().input();
            while (!isEnd()) {
                Player current = game.currentPlayer();
                dialogFactory.dialogCommand(current.getName()).input();
                game.switchPlayer();
            }
    }

    private boolean isEnd() {
        return false;
    }

    private void showHelp() {

    }
}

package org.example.guess_card.controller;

import org.example.common.model.card.Card;
import org.example.common.model.player.Player;
import org.example.guess_card.controller.factory.bet_factory.BetFactory;
import org.example.guess_card.controller.factory.dialog_factory.DialogFactory;
import org.example.guess_card.controller.factory.view_factory.ViewFactory;
import org.example.guess_card.model.Game;
import org.example.guess_card.model.PointCounter;
import org.example.guess_card.model.bet.Bet;

public class GameController {
    private final Game game;
    private final ViewFactory viewFactory;
    private final DialogFactory dialogFactory;
    private final BetFactory betFactory = new BetFactory();
    private final PointCounter counter = new PointCounter();

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
                String key = dialogFactory.dialogCommand(current.getName()).input();
                Bet bet = betFactory.apply(key);
                game.addBetCurrentPlayer(bet);
                Card card = game.currentPlayerTakeCard();
                viewFactory.card(card).show();


                game.switchPlayer();
            }
    }

    private boolean isEnd() {
        return false;
    }

    private void showHelp() {

    }
}

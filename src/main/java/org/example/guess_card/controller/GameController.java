package org.example.guess_card.controller;

import org.example.common.model.card.Card;
import org.example.common.model.player.Player;
import org.example.guess_card.controller.factory.bet_factory.BetFactory;
import org.example.guess_card.controller.factory.dialog_factory.DialogFactory;
import org.example.guess_card.controller.factory.view_factory.ViewFactory;
import org.example.guess_card.model.Game;
import org.example.guess_card.model.storage.GcStorage;
import org.example.guess_card.model.PointCounter;
import org.example.guess_card.model.bet.Bet;
import org.example.guess_card.model.rules.Rules;

import java.util.List;

public class GameController {
    private final Game game;
    private final ViewFactory viewFactory;
    private final DialogFactory dialogFactory;
    private final BetFactory betFactory = new BetFactory();

    public GameController(Game game, ViewFactory viewFactory, DialogFactory dialogFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
        this.dialogFactory = dialogFactory;
    }

    public void go() {
        Rules rules = game.getRules();
        PointCounter counter = game.getCounter();

        viewFactory.tittle().show();
        viewFactory.help(rules, counter).show();

         dialogFactory.dialogStart().input();


        while (true) {
            showDataValues();
            Player current = game.currentPlayer();
            String key = dialogFactory.dialogCommand(current.getName()).input();
            Bet bet = betFactory.apply(key);
            game.addBetCurrentPlayer(bet);
            Game.TakeCardResult result = game.currentPlayerTakeCard();
            viewFactory.card(result.card).show();
            viewFactory.takeResult(result.addPoint).show();

            if (game.isCurrentPlayerWin()) {
                GcStorage.Data data = game.currentPlayerData();

                showDataValues();
                viewFactory.win(data).show();
                break;
            }

            game.switchPlayer();
        }
    }

    private void showHelp() {

    }

    private void showDataValues() {
        List<GcStorage.Data> list = game.dataValues();
        viewFactory.data(list).show();
    }
}

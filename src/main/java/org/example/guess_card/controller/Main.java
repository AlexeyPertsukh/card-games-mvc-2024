package org.example.guess_card.controller;

import org.example.common.model.deck.Deck;
import org.example.common.model.deck_factory.DeckFactory54Card;
import org.example.common.model.player.Player;
import org.example.common.view.card_mapper.Mini9x5PicVer2CardMapper;
import org.example.guess_card.controller.factory.dialog_factory.BaseDialogFactory;
import org.example.guess_card.controller.factory.dialog_factory.DialogFactory;
import org.example.guess_card.controller.factory.view_factory.ColorViewFactory;
import org.example.guess_card.controller.factory.view_factory.ViewFactory;
import org.example.guess_card.model.Game;
import org.example.guess_card.model.rules.Rules;
import org.example.guess_card.model.rules.RulesNumPoint;

public class Main {
    public static void main(String[] args) {
//        Rules rules = new Rules12point();
        Rules rules = new RulesNumPoint(3);
        Deck deck = (new DeckFactory54Card()).get();
        Player first = new Player("Player 1");
        Player second = new Player("Player 2");
        Game game = new Game(rules, deck, first, second);
        ViewFactory viewFactory = new ColorViewFactory(new Mini9x5PicVer2CardMapper());
        DialogFactory dialogFactory = new BaseDialogFactory();
        GameController gameController = new GameController(game, viewFactory, dialogFactory);
        gameController.go();
    }
}

package org.example.guess_card.controller;

import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.deck_factory.DeckFactory54Card;
import org.example.common.model.player.Player;
import org.example.common.view.card_mapper.Mini9x5PicVer2CardMapper;
import org.example.common.view.pic.Pic;
import org.example.guess_card.controller.factory.dialog_factory.BaseDialogFactory;
import org.example.guess_card.controller.factory.dialog_factory.DialogFactory;
import org.example.guess_card.controller.factory.view_factory.BaseViewFactory;
import org.example.guess_card.controller.factory.view_factory.ColorViewFactory;
import org.example.guess_card.controller.factory.view_factory.ViewFactory;
import org.example.guess_card.model.Game;
import org.example.guess_card.model.rules.Rules;
import org.example.guess_card.model.rules.RulesNumPoint;

import java.util.function.Function;

public class MainMasterConfig {
    private static final Function<Card, Pic> cardMapper = new Mini9x5PicVer2CardMapper();
    public static final String MONO = "mono";
    public static final String COLOR = "color";

    public static void main(String... args) {

        Rules rules = new RulesNumPoint(3);
        Deck deck = (new DeckFactory54Card()).get();
        Player first = new Player("Player 1");
        Player second = new Player("Player 2");
        Game game = new Game(rules, deck, first, second);

        String keyColor = "";
        if (args.length != 0) {
            keyColor = args[0];
        }

        ViewFactory viewFactory = viewFactory(keyColor);
        DialogFactory dialogFactory = dialogFactory(keyColor);

        GameController gameController = new GameController(game, viewFactory, dialogFactory);
        gameController.go();
    }

    private static ViewFactory viewFactory(String key) {
        return key.equals(MONO) ? new BaseViewFactory(cardMapper) : new ColorViewFactory(cardMapper);
    }

    private static DialogFactory dialogFactory(String key) {
        return new BaseDialogFactory();
    }
}

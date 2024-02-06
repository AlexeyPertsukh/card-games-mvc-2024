package org.example.black_jack.controller;

import org.example.black_jack.controller.factory.MonoViewFactory;
import org.example.black_jack.controller.factory.ViewFactory;
import org.example.black_jack.controller.game.Game;
import org.example.black_jack.controller.game.GameAmerican;
import org.example.black_jack.model.BjPointCounter;
import org.example.black_jack.model.Rules;
import org.example.common.model.deck.Deck;
import org.example.common.model.deck_factory.DeckFactory54Card;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Dealer;
import org.example.common.model.point_counter.PointCounter;
import org.example.common.view.card_mapper.PicCardMapper;
import org.example.common.view.card_mapper.SmallPicCardMapper;
import org.example.common.view.card_mapper.TextCardMapper;

public class Main {
    public static void main(String[] args) {
        Rules rules = new Rules();
        PointCounter counter = new BjPointCounter();
        Deck deck = (new DeckFactory54Card()).get();
        deck.shuffle();
        Dealer dealer = new Dealer("Dealer",counter);
        Player first = new Player("First");
        Player second = new Player("Second");
        Game game = new GameAmerican(rules, counter, deck, dealer, first, second);

        TextCardMapper textCardMapper = new TextCardMapper();
        PicCardMapper picCardMapper = new SmallPicCardMapper();
        ViewFactory viewFactory = new MonoViewFactory(textCardMapper, picCardMapper);
        GameController controller = new GameController(game, viewFactory);
        controller.go();
    }
}

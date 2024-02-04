package org.example.controller;

import org.example.controller.factory.DialogFactory;
import org.example.controller.factory.ViewFactory;
import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.model.game.Game;
import org.example.model.game.GameAmerican;
import org.example.model.player.Player;
import org.example.model.player.bot.Bot;
import org.example.model.player.bot.Dealer;
import org.example.model.player.bot.DealerAi;
import org.example.model.point_counter.BjPointCounter;
import org.example.view.views.printer.ConsolePrinter;
import org.example.view.views.reader.KeyboardReader;
import org.example.view.views.printer.Printer;
import org.example.view.views.reader.Reader;
import org.example.view.card_mapper.MicroStringsCardMapper;
import org.example.view.card_mapper.TextCardMapper;

public class MainMicroPictureCards {
    public static void main(String[] args) {

//        Printer printer = new ConsolePrinter();
//        Reader reader = new KeyboardReader();
//        Deck deck = DeckFactory54Card.getInstance().create();
//        Player firstPlayer = new Player("Player 1");
////        Player secondPlayer = new Player("Player 2");
//        Player secondPlayer = new Bot("Player 2", new DealerAi(), BjPointCounter.getInstance());
//        Dealer dealer = new Dealer("Dealer", BjPointCounter.getInstance());
//
//        Game game = new GameAmerican(
//                Rules.getInstance(),
//                BjPointCounter.getInstance(),
//                deck,
//                dealer,
//                firstPlayer
////                secondPlayer
//        );
//
//        GameController gameController = new GameController(
//                game,
//                new DialogFactory(printer, reader),
////                new ViewFactory(printer, SmallStringsCardMapper.getInstance())
//                new ViewFactory(printer,  TextCardMapper.getInstance(), MicroStringsCardMapper.getInstance(), deckView)
//                );
//        gameController.go();

    }
}
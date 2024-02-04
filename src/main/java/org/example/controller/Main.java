package org.example.controller;

import org.example.controller.factory.DialogFactory;
import org.example.controller.factory.ViewFactory;
import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.game.GameAm;
import org.example.model.player.bot.Bot;
import org.example.model.player.bot.Dealer;
import org.example.model.player.Player;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.model.player.bot.DealerAi;
import org.example.model.point_counter.BjPointCounter;
import org.example.view.*;

public class Main {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();
        Deck deck = DeckFactory54Card.getInstance().create();
        Player firstPlayer = new Player("Player 1");
//        Player secondPlayer = new Player("Player 2");
        Player secondPlayer = new Bot("Player 2", new DealerAi(), BjPointCounter.getInstance());
        Dealer dealer = new Dealer("Dealer", BjPointCounter.getInstance());

        GameAm gameAm = new GameAm(
                Rules.getInstance(),
                BjPointCounter.getInstance(),
                deck,
                dealer,
                firstPlayer
//                secondPlayer
        );

        GameController gameController = new GameController(
                printer,
                reader,
                gameAm,
                new DialogFactory(printer, reader),
                new ViewFactory(printer)
                );
        gameController.go();

    }
}
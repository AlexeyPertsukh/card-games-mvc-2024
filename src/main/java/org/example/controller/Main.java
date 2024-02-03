package org.example.controller;

import org.example.model.Deck;
import org.example.model.Rules;
import org.example.model.game.Game;
import org.example.model.player.Bot;
import org.example.model.player.Dealer;
import org.example.model.player.Player;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.model.player.ai.DealerAi;
import org.example.model.point_counter.BjPointCounter;
import org.example.view.*;

public class Main {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();
        Deck deck = DeckFactory54Card.getInstance().create();
        Player firstPlayer = new Player("Player 1");
//        Player secondPlayer = new Player("Player 2");
        Player secondPlayer = new Bot<String>("Player 2", new DealerAi());
        Player thirdPlayer = new Dealer<String>("Dealer");

        Game game = new Game(
                Rules.getInstance(),
                BjPointCounter.getInstance(),
                deck,
                firstPlayer, secondPlayer, thirdPlayer
        );

        GameController gameController = new GameController(printer, reader, game);
        gameController.go();

    }
}
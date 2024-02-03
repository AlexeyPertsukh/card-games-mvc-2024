package org.example.controller;

import org.example.model.Deck;
import org.example.model.player.Dealer;
import org.example.model.player.Player;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.view.*;

public class Main {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();
        Deck deck = DeckFactory54Card.getInstance().create();
        Player firstPlayer = new Player("Player 1");
        Player secondPlayer = new Player("Player 2");
        Player thirdPlayer = new Dealer<>("Dealer", "t", "s");
        GameController gameController = new GameController(printer, reader, deck, firstPlayer, secondPlayer, thirdPlayer);
        gameController.go();

    }
}
package org.example.controller;

import org.example.model.Deck;
import org.example.model.player.Player;
import org.example.model.deck_factory.DeckFactory54Card;
import org.example.view.*;

public class Main {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();
        Deck deck = DeckFactory54Card.getInstance().create();
        Player firstPlayer = new Player("Игрок 1");
        Player secondPlayer = new Player("Игрок 2");
        Player thirdPlayer = new Player("Игрок 3");
        GameController gameController = new GameController(printer, reader, deck, firstPlayer, secondPlayer, thirdPlayer);
        gameController.go();

    }
}
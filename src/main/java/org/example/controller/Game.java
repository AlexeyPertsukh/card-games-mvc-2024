package org.example.controller;

import org.example.model.Deck;
import org.example.model.DeckStorage;
import org.example.model.Rules;
import org.example.model.card.Card;
import org.example.model.point_counter.BjPointCounter;
import org.example.model.point_counter.PointCounter;
import org.example.model.result.Result;
import org.example.model.result.ResultFactory;
import org.example.view.Player;
import org.example.view.Printer;
import org.example.view.Reader;
import org.example.view.card_info_factory.SmallStringsCardInfoFactory;
import org.example.view.card_info_factory.TextCardInfoFactory;
import org.example.view.dialog_view.DialogView;
import org.example.view.dialog_view.SelectStringDialogView;
import org.example.view.views.View;
import org.example.view.views.card_view.StringsCardView;
import org.example.view.views.deck_view.StringsDeckView;
import org.example.view.views.group_player_view.BjTextDeckStorageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    private final Printer printer;
    private final Reader reader;
    private final Deck deck;
    private final List<Player> players = new ArrayList<>();

    private final DeckStorage deckStorage = new DeckStorage();
    private final InfoFactory infoFactory = InfoFactory.getInstance();
    private final PointCounter pointCounter = BjPointCounter.getInstance();
    private final ResultFactory resultFactory = new ResultFactory(Rules.getInstance(), pointCounter);

    public Game(Printer printer, Reader reader, Deck deck, Player... players) {
        this.printer = printer;
        this.reader = reader;
        this.deck = deck;

        Collections.addAll(this.players, players);
    }

    public void go() {
        showTittle();
        deck.shuffle();
        setPlayersDeck();

        while (true) {

            showDeckStorage();

            List<Result> results = resultFactory.create(deckStorage);
            showPlayersResult(results);
            break;
        }
    }


    private DialogView<String> dialogView() {
        String tittle = "(y/n)";
        return new SelectStringDialogView(printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                "y", "n"
        );
    }

    private void showTittle() {
        for (String s : infoFactory.tittle()) {
            printer.out(s);
        }
    }

    private void showPlayersResult(List<Result> results) {
        final String template = "%-20S : %-2d points   : %s";

        printer.out("GAME RESULT:");

        for (Player player : players) {
            Result result = findByPlayer(results, player);

            String name = result.getPlayer().getName();
            int point = result.getPoint();
            Result.State state = result.getState();

            String text = String.format(template, name, point, state.name());
            printer.out(text);
        }

    }

    private Result findByPlayer(List<Result> results, Player player) {
        for (Result result : results) {
            if (player == result.getPlayer()) {
                return result;
            }
        }
        throw new IllegalArgumentException("player without in results: " + player.getName());
    }

    private void setPlayersDeck() {
        int n = 0;
        for (Player player : players) {
            Deck playerDeck = new Deck();

            for (int i = 0; i < 3; i++) {
                Card card = deck.take();
                card.open();
                playerDeck.add(card);
            }
            if (n == 1) {
                playerDeck.add(deck.take());
            }
            deckStorage.put(player, playerDeck);
            n++;
        }
    }

    private void showPlayerInfo(Player player) {
        Deck playerDeck = deckStorage.get(player);
        int point = pointCounter.count(playerDeck);
        String pointMessage = "Points: " + point;

        printer.out(player.getName());
        printer.out("-----");

        View<Deck> deckView = new StringsDeckView(printer, SmallStringsCardInfoFactory.getInstance()::create);
        deckView.show(playerDeck);

        printer.out("-----");
        printer.out(pointMessage);
    }

    private void showDeckStorage() {
        View<DeckStorage> storageView = new BjTextDeckStorageView(
                printer,
                TextCardInfoFactory.getInstance()::create,
                BjPointCounter.getInstance()::count
        );
        storageView.show(deckStorage);
    }


}

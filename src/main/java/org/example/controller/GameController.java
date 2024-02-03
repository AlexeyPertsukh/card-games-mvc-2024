package org.example.controller;

import org.example.model.Deck;
import org.example.model.game.Game;
import org.example.model.Rules;
import org.example.model.card.Card;
import org.example.model.game.PlayerState;
import org.example.model.game.PlayerData;
import org.example.model.point_counter.BjPointCounter;
import org.example.model.point_counter.PointCounter;
import org.example.model.player.Player;
import org.example.view.Printer;
import org.example.view.Reader;
import org.example.view.card_info_factory.SmallStringsCardInfoFactory;
import org.example.view.card_info_factory.TextCardInfoFactory;
import org.example.view.dialog_view.DialogView;
import org.example.view.dialog_view.SelectStringDialogView;
import org.example.view.views.View;
import org.example.view.views.deck_view.StringsDeckView;
import org.example.view.views.group_player_data_view.TextListPlayerDataView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameController {

    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    private final Printer printer;
    private final Reader reader;
    private final Deck masterDeck;
    private final List<Player> players = new ArrayList<>();

    private final InfoFactory infoFactory = InfoFactory.getInstance();
    private final PointCounter pointCounter = BjPointCounter.getInstance();
    private final Rules rules = Rules.getInstance();
    private final List<PlayerData> playersData = new ArrayList<>();

    private final Game game;

    public GameController(Printer printer, Reader reader, Deck masterDeck, Player... players) {
        this.printer = printer;
        this.reader = reader;
        this.masterDeck = masterDeck;
        game = new Game(Rules.getInstance(),
                BjPointCounter.getInstance(),
                masterDeck,
                players
                );
    }

    public void go() {
        showTittle();
        masterDeck.shuffle();

        showDialogStart();

        dealingCardsAtBegin();

        while (true) {
            showPlayersData();

            break;
        }
    }

    private void showDialogStart() {
        DialogView<String> dialog = new SelectStringDialogView(
                printer,
                reader,
                "Press 'y' to start game",
                "",
                "y"
        );
        dialog.input();
    }

    private void dealingCardsAtBegin() {

        View<Deck> deckView = new StringsDeckView(
                printer,
                SmallStringsCardInfoFactory.getInstance()::create
        );

        DialogView<String> dialog = new SelectStringDialogView(
                printer,
                reader,
                "Press 'y' to continue",
                "",
                "y"
        );

        for (int i = 0; i < game.numberPlayers(); i++) {

            Player player = game.get(i).getPlayer();
            String text = String.format("[%s] receives cards", player.getName());
            printer.out(text);

            game.giveOpenCard(i, 2);
            game.updateData(i);

            Deck deck = game.get(i).getDeck();
            deckView.show(deck);

//            dialog.input();
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




    private void showPlayersData() {
        View<List<PlayerData>> view = new TextListPlayerDataView(
                printer,
                TextCardInfoFactory.getInstance()::create
        );
        view.show(game.getPlayerDataList());
    }


}

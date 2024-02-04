package org.example.controller;

import org.example.controller.command.Command;
import org.example.controller.command.TakeCardCommand;
import org.example.controller.command.SkipCommand;
import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.Game;
import org.example.model.game.PlayerData;
import org.example.model.player.Bot;
import org.example.model.player.Dealer;
import org.example.model.player.Player;
import org.example.view.Printer;
import org.example.view.Reader;
import org.example.view.card_info_factory.SmallStringsCardInfoFactory;
import org.example.view.card_info_factory.TextCardInfoFactory;
import org.example.view.dialog_view.DialogView;
import org.example.view.dialog_view.SelectStringDialogView;
import org.example.view.views.View;
import org.example.view.views.card_view.StringsCardView;
import org.example.view.views.deck_view.StringsDeckView;
import org.example.view.views.group_player_data_view.TextListPlayerDataView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    private final Printer printer;
    private final Reader reader;
    private final Game game;
    private final InfoFactory infoFactory = InfoFactory.getInstance();
    private final GameController controller = this;
    private State state;


    public GameController(Printer printer, Reader reader, Game game) {
        this.printer = printer;
        this.reader = reader;
        this.game = game;
    }

    public void go() {
        showTittle();

        this.state = new BeginDealCardState();

        while (!isEnd()) {
            state.execute();
        }

    }

    public boolean isEnd() {
        return state instanceof EndGameState;
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

    private void cardsAtBegin() {

        View<Deck> deckView = new StringsDeckView(
                printer,
                SmallStringsCardInfoFactory.getInstance()::create
        );

        for (int i = 0; i < game.numberPlayers(); i++) {

            Player player = game.get(i).getPlayer();
            String text = String.format("[%s] receives cards", player.getName());
            printer.out(text);

            if (isDealer(player)) {
                game.giveBeginCardToDealer(i);
            } else {
                game.giveBeginCardToPlayer(i);
            }

            game.updateData(i);

            Deck deck = game.get(i).getDeck();
            deckView.show(deck);
        }
    }

    private boolean isDealer(Player player) {
        return player instanceof Dealer;
    }

    private boolean isBot(Player player) {
        return player instanceof Bot;
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

    private Command inputCommand() {
        int index = game.getIndexCurrentPlayer();
        PlayerData data = game.get(index);
        Player player = data.getPlayer();

        String tittle = String.format("[%s] input command: %s - take card, %s - skip",
                player.getName(),
                TakeCardCommand.KEY,
                SkipCommand.KEY
        );

        if (isBot(player)) {
            Deck deck = data.getDeck();
            return inputCommandBot(player, deck, tittle);
        }
        return inputCommandPlayer(tittle);
    }

    public void skip() {
        game.next();
    }

    private Command inputCommandPlayer(String tittle) {
        List<String> keys = commandKeys();

        DialogView<String> dialog = new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                keys
        );
        String key = dialog.input();
        return command(key);
    }

    private Command inputCommandBot(Player player, Deck deck, String tittle) {
        printer.out(tittle);
        Bot<String> bot = (Bot<String>) player;
        String key = bot.input(
                deck,
                TakeCardCommand.KEY,
                SkipCommand.KEY,
                game.getCounter()::count
        );
        printer.out(key);
        return command(key);
    }


    public void takeCard() {
        int index = game.getIndexCurrentPlayer();
        PlayerData data = game.get(index);
        List<Card> cards = game.giveOpenCard(index);
        game.updateData(index);

        String text = String.format("[%s] receives card",
                data.getPlayer().getName()
        );
        printer.out(text);

        View<Card> view = new StringsCardView(
                printer,
                SmallStringsCardInfoFactory.getInstance()::create
        );
        view.show(cards.get(0));
    }

    private List<String> commandKeys() {
        List<String> keys = new ArrayList<>();
        keys.add(SkipCommand.KEY);
        keys.add(TakeCardCommand.KEY);
        return keys;
    }

    private Command command(String key) {
        switch (key.toLowerCase()) {
            case SkipCommand.KEY:
                return new SkipCommand(this);
            case TakeCardCommand.KEY:
                return new TakeCardCommand(this);
            default:
                throw new IllegalArgumentException("illegal command: " + key);
        }
    }

    private abstract class State {
        public abstract void execute();
    }

    private class BeginDealCardState extends State {
        @Override
        public void execute() {
            showDialogStart();

            View<Deck> deckView = new StringsDeckView(
                    printer,
                    SmallStringsCardInfoFactory.getInstance()::create
            );

            for (int i = 0; i < game.numberPlayers(); i++) {

                Player player = game.get(i).getPlayer();
                String text = String.format("[%s] receives cards", player.getName());
                printer.out(text);

                if (isDealer(player)) {
                    game.giveBeginCardToDealer(i);
                } else {
                    game.giveBeginCardToPlayer(i);
                }

                game.updateData(i);

                Deck deck = game.get(i).getDeck();
                deckView.show(deck);
            }
            nextState();
        }
    }

    private class EndGameState extends State {

        @Override
        public void execute() {

        }
    }

    private class PlayerActionsState extends State {

        @Override
        public void execute() {
            while (game.hasNextPlayer()) {
                showPlayersData();
                Command command = inputCommand();
                command.execute();

                PlayerData current = game.getCurrent();
                if(!current.isInGame() && game.hasNextPlayer()) {
                    game.next();
                }
            }
        }
    }

    private void nextState() {
        if(state instanceof BeginDealCardState) {
            state = new PlayerActionsState();
            return;
        }
        if(state instanceof PlayerActionsState) {
            state = new EndGameState();
            return;
        }

    }

}

package org.example.controller;

import org.example.controller.command.Command;
import org.example.controller.command.TakeCardCommand;
import org.example.controller.command.SkipCommand;
import org.example.controller.factory.DialogFactory;
import org.example.controller.factory.ViewFactory;
import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.Game;
import org.example.model.game.PlayerData;
import org.example.model.player.Player;
import org.example.model.player.bot.Bot;
import org.example.model.player.bot.Dealer;
import org.example.view.dialog_view.DialogView;
import org.example.view.info_view.InfoView;
import org.example.view.views.View;

import java.util.Iterator;
import java.util.List;

public class GameController {

    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";

    private final Game game;
    private final DialogFactory dialogFactory;
    private final ViewFactory viewFactory;
    private final GameController controller = this;
    private State state;
    private Player currentPlayer;


    public GameController(Game game, DialogFactory dialogFactory, ViewFactory viewFactory) {
        this.game = game;
        this.dialogFactory = dialogFactory;
        this.viewFactory = viewFactory;
    }

    public void go() {
        viewFactory.infoTittle().show();

        this.state = new BeginAddCardState();

        while (!isEnd()) {
            state.execute();
            nextState();

        }

    }

    public boolean isEnd() {
        return state instanceof EndGameState;
    }

    private boolean isBoot(Player player) {
        return player instanceof Bot;
    }


    private void showTable() {
        List<PlayerData> list = game.tableData();
        View table = viewFactory.tableView();

        table.show(list);
    }

    public void takeCardCurrentPlayer() {
        Card card = game.addOpenCard(currentPlayer);
        View cardView = viewFactory.cardView();
        InfoView infoView = viewFactory.infoAddCard(currentPlayer);

        infoView.show();
        cardView.show(card);

    }

    private void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    private abstract class State {
        public abstract void execute();
    }

    private class BeginAddCardState extends State {
        @Override
        public void execute() {
            DialogView<String> dialog = dialogFactory.dialogStart();
            dialog.input();

            View deckView = viewFactory.deckView();

            Iterator<Player> iterator = game.playerIterator();

            while (iterator.hasNext()) {
                Player player = iterator.next();
                beginAddCardPlayer(player);

            }

            beginAddCardDealer();
            DialogView<String> dialogView = dialogFactory.dialogBeginCardDealOver();
            dialogView.input();


        }

        private void beginAddCardPlayer(Player player) {
            List<Card> cards = game.beginAddPlayerCard(player);
            Deck deck = new Deck(cards);

            beginAddCard(player, deck);
        }

        private void beginAddCardDealer() {
            Dealer dealer = game.dealer();
            List<Card> cards = game.beginAddDealerCard();
            Deck deck = new Deck(cards);

            beginAddCard(dealer, deck);
        }

        private void beginAddCard(Player player, Deck deck) {
            InfoView info = viewFactory.infoAddCard(player);
            info.show();

            View deckView = viewFactory.deckView();
            deckView.show(deck);
        }
    }

    private abstract class ActionState extends State {
        protected void onePlayerAction(Player player) {
            setCurrentPlayer(player);
            Command command = null;

            while (true) {
                showTable();

                if (isSkip(command)) {
                    return;
                }
                if(!game.isInGame(player)) {
                    DialogView<String> dialog = dialogFactory.dialogBust(player.getName());
                    dialog.input();
                    return;
                }


                if (isBoot(player)) {
                    Bot bot = (Bot) player;
                    Deck deck = game.deck(player);
                    Bot.BotCommand botCommand = bot.input(deck);
                    String key = toKeyCommand(botCommand);
                    viewFactory.infoText(key).show();
                    command = toCommand(key);
                } else {
                    DialogView<String> dialog = dialogFactory.playerInputDialog(
                            player.getName(),
                            TakeCardCommand.KEY,
                            SkipCommand.KEY
                    );
                    String key = dialog.input();
                    command = toCommand(key);
                }
                command.execute();

            }

        }
        private boolean isSkip(Command command) {
            return command instanceof SkipCommand;
        }
    }

    private class PlayerActionState extends ActionState {

        @Override
        public void execute() {
            Iterator<Player> iterator = game.playerIterator();

            while (iterator.hasNext()) {
                Player player = iterator.next();
                onePlayerAction(player);

            }
            showTable();
        }


    }

    private class DealerOpenCardState extends State {
        @Override
        public void execute() {
            Dealer dealer = game.dealer();
            if(!game.isDeckOpen(dealer)) {
                viewFactory.infoDealerShowCards().show();
                game.openDeck(dealer);

                Deck deck = game.deck(dealer);
                View deckView = viewFactory.deckView();
                deckView.show(deck);

                DialogView<String> dialog = dialogFactory.dialogPressToContinue();
                dialog.input();
            }
        }
    }

    private class DealerActionState extends ActionState {
        @Override
        public void execute() {
            Dealer dealer = game.dealer();
            onePlayerAction(dealer);
        }
    }


    private class EndGameState extends State {

        @Override
        public void execute() {
//            viewFactory.infoEnd().show();
        }
    }

    private Command toCommand(String key) {
        switch (key) {
            case TakeCardCommand.KEY:
                return new TakeCardCommand(this);
            case SkipCommand.KEY:
                return new SkipCommand(this);
            default:
                throw new IllegalArgumentException("illegal player key command: " + key);
        }
    }

    private String toKeyCommand(Bot.BotCommand botCommand) {
        switch (botCommand) {
            case TAKE:
                return TakeCardCommand.KEY;
            case SKIP:
                return SkipCommand.KEY;
            default:
                throw new IllegalArgumentException("illegal bot command: " + botCommand);
        }
    }



    private void nextState() {
        if (state instanceof BeginAddCardState) {
            state = new PlayerActionState();
            return;
        }
        if (state instanceof PlayerActionState) {
            state = new DealerOpenCardState();
            return;
        }
        if (state instanceof DealerOpenCardState) {
            state = new DealerActionState();
            return;
        }

        state = new EndGameState();

    }

}

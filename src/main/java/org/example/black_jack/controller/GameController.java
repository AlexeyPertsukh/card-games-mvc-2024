package org.example.black_jack.controller;

import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.controller.game.PlayerData;
import org.example.black_jack.controller.command.Command;
import org.example.black_jack.controller.command.TakeCardCommand;
import org.example.black_jack.controller.command.SkipCommand;
import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.black_jack.controller.game.Game;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Bot;
import org.example.common.model.player.bot.Dealer;
import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.views.View;

import java.util.Iterator;
import java.util.List;

public class GameController {

    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";

    private final Game game;
    private final ViewFactory viewFactory;
    private final DialogFactory dialogFactory;
    private final GameController controller = this;
    private State state;
    private Player currentPlayer;


    public GameController(Game game, ViewFactory viewFactory, DialogFactory dialogFactory) {
        this.game = game;

        this.viewFactory = viewFactory;
        this.dialogFactory = dialogFactory;
    }

    public void go() {
        viewFactory.tittle().show();

        this.state = new BeginAddCardState();

        while (!isEnd()) {
            state.execute();
            nextState();

        }
        viewFactory.infoEnd().show();

    }

    public boolean isEnd() {
        return state instanceof EndGameState;
    }

    private boolean isBoot(Player player) {
        return player instanceof Bot;
    }


    private void showTable() {
        List<PlayerData> data = game.tableData();
        View table = viewFactory.playerData(data);
        table.show();
    }

    public void takeCardCurrentPlayer() {
        Card card = game.addOpenCard(currentPlayer);

        viewFactory.infoAddCard(currentPlayer).show();
        viewFactory.picCardView(card).show();

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
            View info = viewFactory.infoAddCard(player);
            info.show();

            View deckView = viewFactory.picDeckView(deck);
            deckView.show();
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
                    DialogView<String> dialog = dialogFactory.dialogPlayerInput(
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
                View deckView = viewFactory.picDeckView(deck);
                deckView.show();

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

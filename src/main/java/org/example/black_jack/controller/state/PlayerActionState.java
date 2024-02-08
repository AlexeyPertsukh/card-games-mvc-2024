package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.model.game.Game;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Bot;
import org.example.common.view.dialog_view.DialogView;

import java.util.Iterator;

public class PlayerActionState extends State {  //Игроки(кроме дилера) берут карты или пропускают ходы
    private final static String TAKE_KEY = "t";
    private final static String SKIP_KEY = "s";
    private final Game game;
    private final DialogFactory dialogFactory;
    private final ViewFactory viewFactory;
    private boolean skip;

    private final Iterator<Player> iterator;
    private Player currentPlayer;

    public PlayerActionState(GameController controller) {
        super(controller);
        game = controller.getGame();
        dialogFactory = controller.getDialogFactory();
        viewFactory = controller.getViewFactory();
        iterator = game.playerIterator();
    }

    @Override
    public void execute() {
        while (iterator.hasNext()) {
            currentPlayer = iterator.next();
            playerAction(currentPlayer);
        }
    }

    private void playerAction(Player player) {
        skip = false;
        while (inGame(player) && !skip) {
            Command command = isBot(player) ? autoInput(player) : manualInput(player);
            command.execute();
        }
    }

    private Command manualInput(Player player) {
        String name = player.getName();
        DialogView<String> dialog = dialogFactory.dialogPlayerCmdInput(name, TAKE_KEY, SKIP_KEY);
        String key = dialog.input();
        return toCommand(key);
    }

    private Command autoInput(Player player) {
        Deck deck = game.deck(player);
        Bot bot = (Bot) player;
        String name = bot.getName();

        viewFactory.infoBotCmdInput(name, TAKE_KEY, SKIP_KEY).show();

        Bot.BotCommand botCommand = bot.input(deck);
        String key = toKey(botCommand);
        viewFactory.infoText(key);
        return toCommand(key);
    }

    private boolean inGame(Player player) {
        return game.isInGame(player);
    }

    private boolean isBot(Player player) {
        return player instanceof Bot;
    }

    private void skip() {
        skip = true;
    }

    private void take() {
        Deck deck = game.addOpenCard(currentPlayer);
        viewFactory.infoAddCard(currentPlayer.getName()).show();
        viewFactory.picDeckView(deck).show();
        controller.showTable();
    }

     private String toKey(Bot.BotCommand botCommand) {
        switch (botCommand) {
            case TAKE:
                return TAKE_KEY;
            case SKIP:
                return SKIP_KEY;
            default:
                throw new IllegalArgumentException();
        }
    }

    private Command toCommand(String key) {
        switch (key) {
            case TAKE_KEY:
                return new TakeCommand(this);
            case SKIP_KEY:
                return new SkipCommand(this);
            default:
                throw new IllegalArgumentException("illegal command key: " + key);
        }

    }


    private interface Command {
        void execute();
    }

    private static class TakeCommand implements Command {
        private final PlayerActionState state;

        private TakeCommand(PlayerActionState state) {
            this.state = state;
        }

        @Override
        public void execute() {
            state.take();
        }
    }

    private static class SkipCommand implements Command {
        private final PlayerActionState state;

        private SkipCommand(PlayerActionState state) {
            this.state = state;
        }

        @Override
        public void execute() {
            state.skip();
        }
    }


}

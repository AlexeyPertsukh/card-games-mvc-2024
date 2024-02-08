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

public abstract class AbstractActionState extends State {  //Игроки(кроме дилера) берут карты или пропускают ходы
    protected final static String TAKE_KEY = "t";
    protected final static String SKIP_KEY = "s";
    protected boolean skip;

    public AbstractActionState(GameController controller) {
        super(controller);
    }

    protected Command autoInput(Player player) {
        Deck deck = game.deck(player);
        Bot bot = (Bot) player;
        String name = bot.getName();
        dialogFactory.dialogIsBot(bot.getName()).input();
        viewFactory.infoBotCmdInput(name, TAKE_KEY, SKIP_KEY).show();

        Bot.BotCommand botCommand = bot.input(deck);
        String key = toKey(botCommand);
        viewFactory.infoText(key).show();
        return toCommand(key);
    }

    protected boolean inGame(Player player) {
        return game.isInGame(player);
    }

    protected boolean isBot(Player player) {
        return player instanceof Bot;
    }

    protected void skip() {
        skip = true;
    }
    protected abstract void take();
    protected void take(Player player) {
        Deck deck = game.addOpenCard(player);
        viewFactory.infoAddCard(player.getName()).show();
        viewFactory.picDeckView(deck).show();
        controller.showTable();
    }

     protected String toKey(Bot.BotCommand botCommand) {
        switch (botCommand) {
            case TAKE:
                return TAKE_KEY;
            case SKIP:
                return SKIP_KEY;
            default:
                throw new IllegalArgumentException();
        }
    }

    protected Command toCommand(String key) {
        switch (key) {
            case TAKE_KEY:
                return new TakeCommand(this);
            case SKIP_KEY:
                return new SkipCommand(this);
            default:
                throw new IllegalArgumentException("illegal command key: " + key);
        }

    }


    protected interface Command {
        void execute();
    }

    protected static class TakeCommand implements Command {
        private final AbstractActionState state;

        private TakeCommand(AbstractActionState state) {
            this.state = state;
        }

        @Override
        public void execute() {
            state.take();
        }
    }

    protected static class SkipCommand implements Command {
        private final AbstractActionState state;

        private SkipCommand(AbstractActionState state) {
            this.state = state;
        }

        @Override
        public void execute() {
            state.skip();
        }
    }

}

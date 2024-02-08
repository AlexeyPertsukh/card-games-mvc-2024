package org.example.black_jack.controller;

import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.controller.state.*;
import org.example.black_jack.model.game.PlayerData;
import org.example.black_jack.model.game.Game;
import org.example.common.model.player.Player;
import org.example.common.model.player.bot.Bot;
import org.example.common.view.views.View;

import java.util.List;

public class GameController {

    private static final String DIALOG_ERROR_MESSAGE = "incorrect input";

    private final Game game;
    private final ViewFactory viewFactory;
    private final DialogFactory dialogFactory;
    private org.example.black_jack.controller.state.State state;

    private int indexState;

    public GameController(Game game, ViewFactory viewFactory, DialogFactory dialogFactory) {
        this.game = game;

        this.viewFactory = viewFactory;
        this.dialogFactory = dialogFactory;

        state = state(indexState);


    }

    public Game getGame() {
        return game;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DialogFactory getDialogFactory() {
        return dialogFactory;
    }

    public void go() {

        while (!isEnd()) {
            state.execute();
            selectState();
        }

//        viewFactory.infoEnd().show();

    }

    private boolean isEnd() {
        return state instanceof EndGameState;
    }

    private boolean isBoot(Player player) {
        return player instanceof Bot;
    }

    public void showTable() {
        List<PlayerData> data = game.playerData();
        View table = viewFactory.playerData(data);
        table.show();
    }

    private void selectState() {
        indexState++;
        state = state(indexState);
    }

    private State state(int index) {
        switch (index) {
            case 0:
                return new StartState(this);
            case 1:
                return new BeginDealCardState(this);
            case 2:
                return new PlayerActionState(this);
            case 3:
                return new DealerShowCardState(this);
            case 4:
                return new DealerActionState(this);
            case 5:
                return new CalcResultState(this);

            default:
                return new EndGameState(this);
        }
    }


}

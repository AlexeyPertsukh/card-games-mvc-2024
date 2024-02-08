package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.model.game.Game;
import org.example.black_jack.model.game.PlayerData;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;

import java.util.List;

public class CalcResultState extends State {


    public CalcResultState(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        game.calculateResult();
        controller.showTable();
    }
}

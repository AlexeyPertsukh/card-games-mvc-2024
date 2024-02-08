package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.model.game.Game;
import org.example.black_jack.model.game.PlayerData;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;

import java.util.List;

public class BeginDealCardState extends org.example.black_jack.controller.state.State {

    public BeginDealCardState(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        game.beginAddCard();
        List<PlayerData> list = game.playerData();

        for (PlayerData data : list) {
            Player player = data.getPlayer();
            Deck deck = data.getDeck();
            viewFactory.infoAddCard(player.getName()).show();
            viewFactory.picDeckView(deck).show();
        }
        dialogFactory.dialogBeginCardDealOver().input();
        controller.showTable();
    }
}

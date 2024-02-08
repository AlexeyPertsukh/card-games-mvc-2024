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
    private final Game game;
    private final DialogFactory dialogFactory;
    private final ViewFactory viewFactory;

    public BeginDealCardState(GameController controller) {
        super(controller);
        game = controller.getGame();
        dialogFactory = controller.getDialogFactory();
        viewFactory = controller.getViewFactory();
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
        controller.showTable();
    }
}

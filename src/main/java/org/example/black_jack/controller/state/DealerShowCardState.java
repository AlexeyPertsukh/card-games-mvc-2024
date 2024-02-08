package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.model.game.Game;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.bot.Dealer;

public class DealerShowCardState extends State {
    public DealerShowCardState(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        Dealer dealer = game.dealer();
        viewFactory.infoDealerShowCards().show();
        game.openDeck(dealer);
        Deck dealerDeck = game.deck(dealer);
        viewFactory.picDeckView(dealerDeck).show();
        dialogFactory.dialogPressToContinue().input();
    }
}

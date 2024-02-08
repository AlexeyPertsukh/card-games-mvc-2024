package org.example.black_jack.controller.state;

import org.example.black_jack.controller.game_controller.GameController;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.bot.Dealer;

public class DealerShowCardState extends State {
    public DealerShowCardState(GameController controller) {
        super(controller);
    }

    @Override
    public void execute() {
        Dealer dealer = game.dealer();
        dialogFactory.dialogDealerRevealsCard(dealer.getName()).input();
        viewFactory.infoDealerShowCards().show();
        game.openDeck(dealer);
        Deck dealerDeck = game.deck(dealer);
        viewFactory.picDeckView(dealerDeck).show();
    }
}

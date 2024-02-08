package org.example.black_jack.controller.state;

import org.example.black_jack.controller.GameController;
import org.example.black_jack.controller.factory.dialog_factory.DialogFactory;
import org.example.black_jack.controller.factory.view_factory.ViewFactory;
import org.example.black_jack.model.game.Game;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.bot.Dealer;

public class DealerActionState extends AbstractActionState {
    private final static String TAKE_KEY = "t";
    private final static String SKIP_KEY = "s";
    private final DialogFactory dialogFactory;
    private final ViewFactory viewFactory;
    private final Game game;
    public DealerActionState(GameController controller) {
        super(controller);
        dialogFactory = controller.getDialogFactory();
        viewFactory = controller.getViewFactory();
        game = controller.getGame();
    }

    @Override
    public void execute() {
        Dealer dealer = game.dealer();
        dealerAction(dealer);
    }

    private void dealerAction(Dealer dealer) {
        skip = false;
        while (!skip && inGame(dealer)) {

            Command command = autoInput(dealer);
            command.execute();
            if (!inGame(dealer)) {
                dialogFactory.dialogNotInGame(dealer.getName()).input();
                break;
            }
            if (command instanceof SkipCommand) {
                break;
            }
        }
    }

    @Override
    protected void take() {
        Dealer dealer = game.dealer();
        take(dealer);
    }

}

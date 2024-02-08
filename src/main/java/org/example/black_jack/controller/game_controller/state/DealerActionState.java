package org.example.black_jack.controller.game_controller.state;

import org.example.black_jack.controller.game_controller.GameController;
import org.example.common.model.player.bot.Dealer;

public class DealerActionState extends AbstractActionState {
    private final static String TAKE_KEY = "t";
    private final static String SKIP_KEY = "s";
    public DealerActionState(GameController controller) {
        super(controller);

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

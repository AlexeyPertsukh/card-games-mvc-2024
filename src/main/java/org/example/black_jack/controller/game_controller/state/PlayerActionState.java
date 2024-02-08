package org.example.black_jack.controller.game_controller.state;

import org.example.black_jack.controller.game_controller.GameController;

import org.example.common.model.player.Player;
import org.example.common.view.dialog_view.DialogView;

import java.util.Iterator;

public class PlayerActionState extends AbstractActionState {  //Игроки(кроме дилера) берут карты или пропускают ходы
    private final Iterator<Player> iterator;
    private Player currentPlayer;

    public PlayerActionState(GameController controller) {
        super(controller);
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
        while (!skip && inGame(player)) {

            Command command = isBot(player) ? autoInput(player) : manualInput(player);
            command.execute();
            if (!inGame(player)) {
                dialogFactory.dialogNotInGame(player.getName()).input();
                break;
            }
            if (command instanceof SkipCommand) {
                break;
            }
        }
    }

    private Command manualInput(Player player) {
        String name = player.getName();
        DialogView<String> dialog = dialogFactory.dialogPlayerCmdInput(name, TAKE_KEY, SKIP_KEY);
        String key = dialog.input();
        return toCommand(key);
    }

    @Override
    protected void take() {
        take(currentPlayer);
    }

}

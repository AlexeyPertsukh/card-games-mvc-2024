package org.example.black_jack.controller.command;

import org.example.black_jack.controller.GameController;
import org.example.common.controller.command.AbstractCommand;
import org.example.common.controller.command.Command;

public abstract class GameControllerCommand extends AbstractCommand<GameController> {
    protected GameControllerCommand(GameController controller) {
        super(controller);
    }
}

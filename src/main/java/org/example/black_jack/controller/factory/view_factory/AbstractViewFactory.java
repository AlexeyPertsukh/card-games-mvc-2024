package org.example.black_jack.controller.factory.view_factory;

import org.example.common.view.info_view.InfoView;
import org.example.common.view.views.View;

public abstract class AbstractViewFactory implements ViewFactory{
    protected static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };
    protected static final String END_MESSAGE = "END GAME";
    protected static final String ADD_CARDS_TEMPLATE = "[%s] receives cards: ";
    protected static final String DEALER_REVEALS_MESSAGE = "the dealer reveals his cards";
    protected static final String DIALOG_INPUT_CMD_TEMPLATE = "[%s] input command: %s - take card, %s - skip";

//    @Override
//    public View infoBotCmdInput(String name) {
//        return new InfoView(DEALER_REVEALS_MESSAGE, printer);
//    }

}

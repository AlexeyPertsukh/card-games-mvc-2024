package org.example.black_jack.controller.factory;

public abstract class AbstractViewFactory implements ViewFactory{
    protected static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };
    protected static final String END_MESSAGE = "END GAME";
    protected static final String ADD_CARDS_TEMPLATE = "[%s] receives cards: ";

    protected static final String DIALOG_ERROR_MESSAGE = "incorrect input";
    protected static final String BUST_MESSAGE_TEMPLATE = "[%s] is BUST, press '%s' to continue";
    protected static final String BASIC_PRESS_TO_CONTINUE_TEMPLATE = "press '%s' to continue";
    protected static final String DEFAULT_CONTINUE_KEY = "y";
    protected static final String DEALER_REVEALS_MESSAGE = "the dealer reveals his cards";

}

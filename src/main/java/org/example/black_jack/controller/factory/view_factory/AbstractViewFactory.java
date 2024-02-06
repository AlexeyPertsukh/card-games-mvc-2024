package org.example.black_jack.controller.factory.view_factory;

public abstract class AbstractViewFactory implements ViewFactory{
    protected static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };
    protected static final String END_MESSAGE = "END GAME";
    protected static final String ADD_CARDS_TEMPLATE = "[%s] receives cards: ";
    protected static final String DEALER_REVEALS_MESSAGE = "the dealer reveals his cards";

}

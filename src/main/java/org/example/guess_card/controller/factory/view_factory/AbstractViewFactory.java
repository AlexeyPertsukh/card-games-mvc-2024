package org.example.guess_card.controller.factory.view_factory;

public abstract class AbstractViewFactory implements ViewFactory{
    protected static final String[] TITTLE = {
            "*******************",
            "  GUESS THE CARD  ",
            "*******************",
    };

    protected static final String WIN_TEMPLATE = "WON: %s, points: %d  ";
    protected static final String END_MESSAGE = "END GAME";

}

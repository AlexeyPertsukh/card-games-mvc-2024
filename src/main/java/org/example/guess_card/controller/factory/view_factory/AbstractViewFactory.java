package org.example.guess_card.controller.factory.view_factory;

public abstract class AbstractViewFactory implements ViewFactory{
    protected static final String[] TITTLE = {
            "*******************",
            "  GUESS THE CARD  ",
            "*******************",
    };

    protected static final String[] MESSAGE_GAME_RESULT = {
            "=================",
            "#  GAME RESULT  #",
            "=================",
    };

    protected static final String END_MESSAGE = "END GAME";
}

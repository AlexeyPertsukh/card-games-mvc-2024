package org.example.guess_card.controller.factory.view_factory;


import org.example.guess_card.controller.factory.bet_factory.BetFactory;
import org.example.guess_card.model.PointCounter;
import org.example.guess_card.model.rules.Rules;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractViewFactory implements ViewFactory {
    protected static final String[] TITTLE = {
            "*******************",
            "  GUESS THE CARD  ",
            "*******************",
    };

    protected String[] textHelp(Rules rules, PointCounter counter) {
        List<String> strings = new ArrayList<>();
        strings.add("---------");
        strings.add("The goal of the game is to guess the card in the deck.");
        strings.add(String.format("The first one to score %d points wins.", rules.winPoint()));
        strings.add("Bets on cards:");
        strings.add(String.format("%s - red, %d point", BetFactory.Key.COLOR_RED.getText(), counter.colorPoint()));
        strings.add(String.format("%s - black, %d point", BetFactory.Key.COLOR_BLACK.getText(), counter.colorPoint()));
        strings.add(String.format("%s - picture, %d points", BetFactory.Key.PICTURE.getText(), counter.picturePoint()));
        strings.add(String.format("%s - joker, %d points", BetFactory.Key.JOKER.getText(), counter.jokerPoint()));
        strings.add("---------");

        return strings.toArray(new String[0]);
    }


    protected static final String WIN_TEMPLATE = "WON: %s, points: %d  ";
    protected static final String END_MESSAGE = "END GAME";

}

package org.example.guess_card.controller.factory.bet_factory;

import org.example.common.model.card.CardSuit;
import org.example.guess_card.model.bet.Bet;
import org.example.guess_card.model.bet.ColorBet;

import java.util.function.Function;

public class BetFactory implements Function<String, Bet> {

    @Override
    public Bet apply(String s) {
        if (!contains(s)) {
            throw new IllegalArgumentException("illegal key string: " + s);
        }

        Key key = getBy(s);
        if (isColor(key)) {
            CardSuit.Color color = color(key);
            return new ColorBet(color);
        }
        throw new IllegalArgumentException("illegal key string: " + s);
    }

    private CardSuit.Color color(Key key) {
        switch (key) {
            case COLOR_RED: return CardSuit.Color.RED;
            case COLOR_BLACK: return CardSuit.Color.BLACK;
            default: throw new IllegalArgumentException("illegal key color: " + key);
        }
    }

    public boolean contains(String s) {
        try {
            getBy(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }

    private Key getBy(String s) {
        for (Key key : Key.values()) {
            if (key.text.equalsIgnoreCase(s)) {
                return key;
            }
        }
        throw new IllegalArgumentException("illegal key string: " + s);
    }

    private boolean isColor(Key key) {
        return key == Key.COLOR_BLACK || key == Key.COLOR_RED;
    }


    public enum Key {
        COLOR_RED("r"),
        COLOR_BLACK("b"),
        ;
        private final String text;

        Key(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

    }
}

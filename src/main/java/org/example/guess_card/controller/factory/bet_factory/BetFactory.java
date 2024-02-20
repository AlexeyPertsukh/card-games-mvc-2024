package org.example.guess_card.controller.factory.bet_factory;

import org.example.common.model.card.CardSuit;
import org.example.guess_card.model.bet.Bet;
import org.example.guess_card.model.bet.ColorBet;
import org.example.guess_card.model.bet.PictureBet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BetFactory implements Function<String, Bet> {

    @Override
    public Bet apply(String s) {
        if (!contains(s)) {
            throw new IllegalArgumentException("illegal key string: " + s);
        }

        Key key = getBy(s);
        return key.getBet();
    }

    public List<String> keys() {
        List<String> out = new ArrayList<>();
        for (Key key : Key.values()) {
            out.add(key.text);
        }
        return out;
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


    public enum Key {
        COLOR_RED("r", new ColorBet(CardSuit.Color.RED)),
        COLOR_BLACK("b", new ColorBet(CardSuit.Color.BLACK)),
        PICTURE("p", new PictureBet()),
        JOKER("j", new PictureBet()),
        ;
        private final String text;
        private final Bet bet;

        Key(String text, Bet bet) {
            this.text = text;
            this.bet = bet;
        }

        public String getText() {
            return text;
        }

        public Bet getBet() {
            return bet;
        }
    }

}

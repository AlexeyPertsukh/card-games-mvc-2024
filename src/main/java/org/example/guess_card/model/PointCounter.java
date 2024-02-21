package org.example.guess_card.model;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;
import org.example.guess_card.model.bet.Bet;
import org.example.guess_card.model.bet.ColorBet;
import org.example.guess_card.model.bet.JokerBet;
import org.example.guess_card.model.bet.PictureBet;

public class PointCounter {
    public int count(Card winCard, Bet bet) {
        if(isColorBet(bet)) {
            return countColorBet(winCard, bet);
        }

        if(isPictureBet(bet)) {
            return countPictureBet(winCard, bet);
        }

        if(isJokerBet(bet)) {
            return countJokerBet(winCard, bet);
        }

        throw new IllegalArgumentException("illegal bet: " + bet);
    }

    private boolean isColorBet(Bet bet) {
        return bet instanceof ColorBet;
    }

    private boolean isPictureBet(Bet bet) {
        return bet instanceof PictureBet;
    }

    private boolean isJokerBet(Bet bet) {
        return bet instanceof JokerBet;
    }

    private int countColorBet(Card winCard, Bet bet) {
        if(winCard.getRank()==CardRank.JOKER) {
            return Point.NONE.value;
        }
        return winCard.getSuit().getColor() == bet.get() ? Point.COLOR.value : Point.NONE.value;
    }

    private int countJokerBet(Card winCard, Bet bet) {
        return winCard.getRank() == CardRank.JOKER ? Point.JOKER.value : Point.NONE.value;
    }

    private int countPictureBet(Card winCard, Bet bet) {
        switch (winCard.getRank()) {
            case JACK:
            case QUEEN:
            case KING:
            case ACE:
                return Point.PICTURE.value;
            default:
                return Point.NONE.value;
        }
    }

    public int colorPoint() {
        return Point.COLOR.value;
    }

    public int picturePoint() {
        return Point.PICTURE.value;
    }

    public int jokerPoint() {
        return Point.JOKER.value;
    }

    private enum Point {
        NONE(0),
        COLOR(1),
        PICTURE(2),
        JOKER(10),
        ;
        private final int value;

        Point(int value) {
            this.value = value;
        }
    }

}

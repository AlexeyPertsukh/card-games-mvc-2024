package org.example.guess_card.model;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.guess_card.model.bet.Bet;
import org.example.guess_card.model.bet.ColorBet;
import org.example.guess_card.model.bet.JokerBet;
import org.example.guess_card.model.bet.PictureBet;

public class PointCounter {
    public PointCounterResult count(Card winCard, Bet bet) {

        if (isJokerBet(bet)) {
            return countJokerBet(winCard);
        }

        if (isJokerCard(winCard)) {
            return new ResetResult();
        }

        if (isColorBet(bet)) {
            return countColorBet(winCard, bet);
        }

        if (isPictureBet(bet)) {
            return countPictureBet(winCard, bet);
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

    private boolean isJokerCard(Card card) {
        return card.getRank() == CardRank.JOKER;
    }

    private PointCounterResult countColorBet(Card winCard, Bet bet) {
        return winCard.getSuit().getColor() == bet.get() ? normResult(Point.COLOR.value) : normResult(Point.NONE.value);
    }

    private PointCounterResult countJokerBet(Card winCard) {
        return winCard.getRank() == CardRank.JOKER ? normResult(Point.JOKER.value) : normResult(Point.NONE.value);
    }

    private PointCounterResult countPictureBet(Card winCard, Bet bet) {
        switch (winCard.getRank()) {
            case JACK:
            case QUEEN:
            case KING:
            case ACE:
                return normResult(Point.PICTURE.value);
            default:
                return normResult(Point.NONE.value);
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

    private PointCounterResult normResult(int point) {
        return new NormalResult(point);
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

    public interface PointCounterResult {
        int point();

        boolean isReset();
    }

    public static class NormalResult implements PointCounterResult {
        private final int point;

        public NormalResult(int point) {
            this.point = point;
        }

        @Override
        public int point() {
            return point;
        }

        @Override
        public boolean isReset() {
            return false;
        }
    }

    public static class ResetResult implements PointCounterResult {

        @Override
        public int point() {
            return 0;
        }

        @Override
        public boolean isReset() {
            return true;
        }
    }

}

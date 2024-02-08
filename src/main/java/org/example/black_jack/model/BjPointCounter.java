package org.example.black_jack.model;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.point_counter.PointCounter;

public class BjPointCounter implements PointCounter {
    private static final int MAX_POINT = 21;

    @Override
    public Integer apply(org.example.common.model.deck.Deck deck) {
        int points = 0;
        for (Card card : deck.toList()) {
            if(card.isOpen()) {
                points += cardPoint(points, card);
            }
        }
        return points;
    }

    private static int cardPoint(int prevPoints, Card deck) {
        CardRank rank = deck.getRank();
        switch (rank) {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 10;
            case QUEEN:
                return 10;
            case KING:
                return 10;
            case ACE:
                return MAX_POINT > prevPoints ? 11: 1;

            default:
                throw new IllegalArgumentException("illegal card rank: " + rank);
        }
    }


}

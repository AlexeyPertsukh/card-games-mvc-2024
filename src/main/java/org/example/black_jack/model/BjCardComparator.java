package org.example.black_jack.model;

import org.example.common.model.card.Card;

import java.util.Comparator;

public class BjCardComparator implements Comparator<Card> {
    @Override
    public int compare(Card first, Card second) {
        return first.getRank().ordinal() - second.getRank().ordinal() ;
    }
}

package org.example.black_jack.model;

import org.example.common.model.card.Card;

import java.util.Comparator;

public class BjCardComparator implements Comparator<Card> {
    @Override
    public int compare(Card first, Card second) {
        if(!first.isOpen() || !second.isOpen()) {   //не сортируем, если карта закрыта
            return 0;
        }
        return first.getRank().ordinal() - second.getRank().ordinal() ;
    }
}

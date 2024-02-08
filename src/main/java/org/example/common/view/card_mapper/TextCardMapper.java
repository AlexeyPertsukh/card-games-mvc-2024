package org.example.common.view.card_mapper;

import org.example.common.model.card.Card;

public class TextCardMapper implements CardMapper<String> {
    private final static String BACK = "<hidden>";

    @Override
    public String apply(Card deck) {
        if(!deck.isOpen()) {
            return BACK;
        }
        String infoSuit = deck.getSuit().getIcon();
        String infoRank = deck.getRank().getLabel();
        return String.format("%s %s", infoSuit, infoRank);
    }
}

package org.example.common.view.card_mapper;

import org.example.common.model.card.Card;

public class TextCardMapper implements CardMapper<String> {
    private final static String BACK = "<hidden>";

    @Override
    public String apply(Card card) {
        if(!card.isOpen()) {
            return BACK;
        }
        String infoSuit = card.getSuit().getIcon();
        String infoRank = card.getRank().getLabel();
        return String.format("%s %s", infoSuit, infoRank);
    }
}

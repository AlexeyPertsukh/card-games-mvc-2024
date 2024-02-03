package org.example.view.card_info_factory;

import org.example.model.card.Card;

public class TextCardInfoFactory implements CardInfoFactory<String>{
    private final static String BACK = "hidden";
    private static TextCardInfoFactory factory;

    public static TextCardInfoFactory getInstance() {
        if (factory == null) {
            factory = new TextCardInfoFactory();
        }
        return factory;
    }

    @Override
    public String create(Card card) {
        if(!card.isOpen()) {
            return BACK;
        }
        String infoSuit = card.getSuit().getIcon();
        String infoRank = card.getRank().getLabel();
        return String.format("%s %s", infoSuit, infoRank);
    }
}

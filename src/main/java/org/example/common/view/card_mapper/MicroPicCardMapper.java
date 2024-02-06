package org.example.common.view.card_mapper;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;
import org.example.common.view.pic.Pic;

public class MicroPicCardMapper implements CardMapper<Pic> {
    private static final String[] SPADES = {
            "\uD83C\uDCA2",
            "\uD83C\uDCA3",
            "\uD83C\uDCA4",
            "\uD83C\uDCA5",
            "\uD83C\uDCA6",
            "\uD83C\uDCA7",
            "\uD83C\uDCA8",
            "\uD83C\uDCA9",
            "\uD83C\uDCAA",

            "\uD83C\uDCAB",
            "\uD83C\uDCAD",
            "\uD83C\uDCAE",
            "\uD83C\uDCA1",
    };

    private static final String[] HEARTS = {
            "\uD83C\uDCB2",
            "\uD83C\uDCB3",
            "\uD83C\uDCB4",
            "\uD83C\uDCB5",
            "\uD83C\uDCB6",
            "\uD83C\uDCB7",
            "\uD83C\uDCB8",
            "\uD83C\uDCB9",
            "\uD83C\uDCBA",

            "\uD83C\uDCBB",
            "\uD83C\uDCBD",
            "\uD83C\uDCBE",
            "\uD83C\uDCB1",
    };

    private static final String[] DIAMONDS = {
            "\uD83C\uDCC2",
            "\uD83C\uDCC3",
            "\uD83C\uDCC4",
            "\uD83C\uDCC5",
            "\uD83C\uDCC6",
            "\uD83C\uDCC7",
            "\uD83C\uDCC8",
            "\uD83C\uDCC9",
            "\uD83C\uDCCA",

            "\uD83C\uDCCB",
            "\uD83C\uDCCD",
            "\uD83C\uDCCE",
            "\uD83C\uDCC1",
    };

    private static final String[] CLUBS = {
            "\uD83C\uDCD2",
            "\uD83C\uDCD3",
            "\uD83C\uDCD4",
            "\uD83C\uDCD5",
            "\uD83C\uDCD6",
            "\uD83C\uDCD7",
            "\uD83C\uDCD8",
            "\uD83C\uDCD9",
            "\uD83C\uDCDA",

            "\uD83C\uDCDB",
            "\uD83C\uDCDD",
            "\uD83C\uDCDE",
            "\uD83C\uDCD1",
    };

    private static final String BACK = "\uD83C\uDCA0";
    private static final String JOKER_RED = "\uD83C\uDCDF";
    private static final String JOKER_BLACK = "\uD83C\uDCBF";


    public MicroPicCardMapper() {
    }

    @Override
    public Pic apply(Card card) {
        if(!card.isOpen()) {
            return pic(BACK);
        }

        CardRank rank = card.getRank();
        if(rank == CardRank.JOKER) {
            if(card.getSuit().getColor() == CardSuit.Color.RED) {
                return pic(JOKER_RED);
            }
            return pic(JOKER_BLACK);
        }

        int num = rank.ordinal() - 1;

        String s = "";
        switch (card.getSuit()) {
            case SPADE: s = SPADES[num];
            case HEART: s = HEARTS[num];
            case CLUB: s = CLUBS[num];
            case DIAMOND: s = DIAMONDS[num];
        }
        return pic(s);
    }

    private Pic pic(String s) {
        return new Pic(s);
    }

}

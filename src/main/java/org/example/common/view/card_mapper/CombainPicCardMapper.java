package org.example.common.view.card_mapper;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardRank;
import org.example.common.model.card.CardSuit;
import org.example.common.view.pic.Pic;

public abstract class CombainPicCardMapper extends PicCardMapper {
    @Override
    public Pic apply(Card card) {
        if (!card.isOpen()) {
            return pic(back());
        }

        String[] template = rankPicture(card.getRank());
        String[] pic = cloneArr(template);
        String changeSym = changeSymbol();
        String suitSym = suitPicture(card.getSuit());

        for (int i = 0; i < pic.length; i++) {
            pic[i] = pic[i].replace(changeSym, suitSym);
        }
        return pic(pic);
    }

    private String[] rankPicture(CardRank rank) {
        switch (rank) {
            case JOKER:
                return joker();
            case TWO:
                return two();
            case THREE:
                return three();
            case FOUR:
                return four();
            case FIVE:
                return five();
            case SIX:
                return six();
            case SEVEN:
                return seven();
            case EIGHT:
                return eight();
            case NINE:
                return nine();
            case TEN:
                return ten();
            case JACK:
                return jack();
            case QUEEN:
                return queen();
            case KING:
                return king();
            case ACE:
                return ace();
            default:
                throw new IllegalArgumentException("illegal card rank: " + rank);
        }
    }

    private String suitPicture(CardSuit suit) {
        if(suit.isNone()) {
            return suit.getIcon();
        }
        switch (suit) {
            case DIAMOND:
                return diamond();
            case HEART:
                return heart();
            case CLUB:
                return club();
            case SPADE:
                return spade();
            default:
                throw new IllegalArgumentException("illegal suit: " + suit);
        }
    }

    protected abstract String changeSymbol();

    protected abstract String[] back();

    protected abstract String[] joker();

    protected abstract String[] two();

    protected abstract String[] three();

    protected abstract String[] four();

    protected abstract String[] five();

    protected abstract String[] six();

    protected abstract String[] seven();

    protected abstract String[] eight();

    protected abstract String[] nine();

    protected abstract String[] ten();

    protected abstract String[] jack();

    protected abstract String[] queen();

    protected abstract String[] king();

    protected abstract String[] ace();


    protected abstract String diamond();

    protected abstract String heart();

    protected abstract String club();

    protected abstract String spade();

    private String[] cloneArr(String[] array) {
        String[] out = new String[array.length];
        System.arraycopy(array, 0, out, 0, array.length);
        return out;
    }

    private Pic pic(String[] value) {
        return new Pic(value);
    }

}

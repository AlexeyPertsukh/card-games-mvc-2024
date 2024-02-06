package org.example.common.view.views.deck_view;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public class PicDeckView extends DeckView<String[]> {

    public PicDeckView(Deck value, Printer printer, Function<Card, String[]> map) {
        super(value, printer, map);
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> cards = value.toList();
        String[] pic = null;
        for (Card card : cards) {
            String[] current = map.apply(card);
            if (pic == null) {
                pic = current;
                continue;
            }
            pic = combine(pic, current);
        }

        for (String s : pic) {
            printer.output(s);
        }
    }

    protected static String[] combine(String[] first, String[] second) {
        String[] out = new String[first.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = first[i] + second[i];
        }
        return out;
    }
}

package org.example.view.views.deck_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.Printer;

import java.util.List;
import java.util.function.Function;

public class StringsDeckView extends DeckView<String[]> {

    public StringsDeckView(Printer printer, Function<Card, String[]> map) {
        super(printer, map);
    }

    @Override
    public void show(Deck deck) {
        if (deck.size() == 0) {
            return;
        }

        List<Card> cards = deck.toList();
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
            printer.out(s);
        }
    }

    private static String[] combine(String[] first, String[] second) {
        String[] out = new String[first.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = first[i] + second[i];
        }
        return out;
    }
}

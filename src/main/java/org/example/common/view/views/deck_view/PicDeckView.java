package org.example.common.view.views.deck_view;

import org.example.common.model.card.Card;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public class PicDeckView extends DeckView<Pic> {

    public PicDeckView(org.example.common.model.deck.Deck value, Printer printer, Function<Card, Pic> map) {
        super(value, printer, map);
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> decks = value.toList();
        Pic pic = null;
        for (Card deck : decks) {
            Pic current = map.apply(deck);
            if (pic == null) {
                pic = current;
                continue;
            }
            pic = combine(pic, current);
        }

        for (String s : pic.value()) {
            printer.output(s);
        }
    }

    protected static Pic combine(Pic first, Pic second) {
        String[] out = new String[first.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = first.get(i) + second.get(i);
        }
        return new Pic(out);
    }
}

package org.example.common.view.views.deck_view;

import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public class TextDeckView extends DeckView<String> {

    public TextDeckView(org.example.common.model.deck.Deck value, Printer printer, Function<Card, String> map) {
        super(value, printer, map);
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> decks = value.toList();
        for (Card deck : decks) {
            String text = map.apply(deck);
            printer.output(text);
        }
    }


}

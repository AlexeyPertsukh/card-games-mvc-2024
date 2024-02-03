package org.example.view.views.deck_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.Printer;

import java.util.List;
import java.util.function.Function;

public class TextDeckView extends DeckView<String> {

    public TextDeckView(Printer printer, Function<Card, String> map) {
        super(printer, map);
    }

    @Override
    public void show(Deck deck) {
        if (deck.size() == 0) {
            return;
        }

        List<Card> cards = deck.toList();
        for (Card card : cards) {
            String text = map.apply(card);
            printer.out(text);
        }
    }


}

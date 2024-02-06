package org.example.view.views.deck_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.printer.ColorPrinter;

import java.util.List;
import java.util.function.Function;

public class TextColorDeckView extends DeckView<String> implements ColorMapper{
    private final ColorPrinter colorPrinter;
    public TextColorDeckView(ColorPrinter colorPrinter, Function<Card, String> map) {
        super(colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show(Deck deck) {
        if (deck.size() == 0) {
            return;
        }

        List<Card> cards = deck.toList();
        for (Card card : cards) {
            ColorPrinter.Color color = color(card);
            String text = map.apply(card);
            colorPrinter.colorOut(color, text + "  ");
        }
        colorPrinter.output("");
    }


}

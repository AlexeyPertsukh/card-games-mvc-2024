package org.example.view.views.deck_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardSuit;
import org.example.view.views.printer.ColorPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringsColorDeckView extends StringsDeckView {
    private final ColorPrinter colorPrinter;

    public StringsColorDeckView(ColorPrinter colorPrinter, Function<Card, String[]> map) {
        super(colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show(Deck deck) {
        if (deck.size() == 0) {
            return;
        }

        List<Card> cards = deck.toList();
        List<String[]> pictures = new ArrayList<>();

        for (Card card : cards) {
            String[] pic = map.apply(card);
            pictures.add(pic);
        }

        int length = pictures.get(0).length;
        for (int i = 0; i < length; i++) {
            showLine(cards, pictures, i);
        }

    }

    private void showLine(List<Card> cards, List<String[]> pictures, int line) {
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            String[] pic = pictures.get(i);
            ColorPrinter.Color color = color(card);
            colorPrinter.colorOut(color, pic[line]);
        }
        colorPrinter.output("");
    }

    private ColorPrinter.Color color(Card card) {
        if (!card.isOpen()) {
            return ColorPrinter.Color.RESET;
        }
        switch (card.getSuit().getColor()) {
            case BLACK:
                return ColorPrinter.Color.GREEN;
            case RED:
                return ColorPrinter.Color.RED;
            default:
                return ColorPrinter.Color.RESET;
        }
    }


}

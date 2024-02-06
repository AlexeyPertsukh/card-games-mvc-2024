package org.example.common.view.views.deck_view;

import org.example.common.model.card.CardSuit;
import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;

import java.util.List;
import java.util.function.Function;

public class ColorTextDeckView extends DeckView<String> {
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();
    public ColorTextDeckView(Deck value, ColorPrinter colorPrinter, Function<Card, String> map) {
        super(value, colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show() {
        if (value.size() == 0) {
            return;
        }

        List<Card> cards = value.toList();
        for (Card card : cards) {
            ColorPrinter.Color color = colorMapper.apply(card.getSuit().getColor());
            String text = map.apply(card);
            colorPrinter.colorOut(color, text + "  ");
        }
        colorPrinter.output();
    }


}

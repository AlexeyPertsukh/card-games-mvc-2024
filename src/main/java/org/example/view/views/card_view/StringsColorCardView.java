package org.example.view.views.card_view;

import org.example.model.card.Card;
import org.example.view.printer.ColorPrinter;

import java.util.function.Function;

public class StringsColorCardView extends CardView<String[]> {
    private final ColorPrinter colorPrinter;

    public StringsColorCardView(ColorPrinter colorPrinter, Function<Card, String[]> map) {
        super(colorPrinter, map);
        this.colorPrinter = colorPrinter;

    }

    @Override
    public void show(Card card) {
        String[] picture = map.apply(card);
        ColorPrinter.Color color = color(card);

        for (String s : picture) {
            colorPrinter.colorOutput(color, s);
        }
    }

    private ColorPrinter.Color color(Card card) {
        if (!card.isOpen()) {
            return ColorPrinter.Color.DEFAULT;
        }
        switch (card.getSuit().getColor()) {
            case BLACK:
                return ColorPrinter.Color.GREEN;
            case RED:
                return ColorPrinter.Color.RED;
            default:
                return ColorPrinter.Color.DEFAULT;
        }
    }
}

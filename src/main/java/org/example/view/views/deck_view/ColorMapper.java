package org.example.view.views.deck_view;

import org.example.model.card.Card;
import org.example.view.views.printer.ColorPrinter;

public interface ColorMapper {
     default ColorPrinter.Color color(Card card) {
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

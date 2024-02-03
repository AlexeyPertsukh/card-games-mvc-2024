package org.example.view.views.card_view;

import org.example.model.card.Card;
import org.example.view.Printer;

import java.util.function.Function;

public class TextCardView extends CardView<String> {

    public TextCardView(Printer printer, Function<Card, String> map) {
        super(printer, map);
    }

    @Override
    public void show(Card card) {
        String text = map.apply(card);
        printer.out(text);
    }


}

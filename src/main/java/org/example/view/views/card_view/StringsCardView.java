package org.example.view.views.card_view;

import org.example.model.card.Card;
import org.example.view.Printer;

import java.util.function.Function;

public class StringsCardView extends CardView<String[]> {

    public StringsCardView(Printer printer, Function<Card, String[]> map) {
        super(printer, map);
    }

    @Override
    public void show(Card card) {
        String[] picture = map.apply(card);
        for (String s : picture) {
            printer.out(s);
        }
    }
}

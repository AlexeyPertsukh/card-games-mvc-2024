package org.example.common.view.views.card_view;

import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;

import java.util.function.Function;

public class PicCardView extends CardView<String[]> implements org.example.common.view.views.View {

    public PicCardView(Card value, Printer printer, Function<Card, String[]> map) {
        super(value, printer, map);
    }

    @Override
    public void show() {
        String[] picture = map.apply(value);
        for (String s : picture) {
            printer.output(s);
        }
    }
}

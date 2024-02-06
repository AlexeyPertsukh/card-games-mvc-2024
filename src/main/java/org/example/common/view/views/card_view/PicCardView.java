package org.example.common.view.views.card_view;

import org.example.common.model.card.Card;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.Printer;

import java.util.function.Function;

public class PicCardView extends CardView<Pic> implements org.example.common.view.views.View {

    public PicCardView(Card value, Printer printer, Function<Card, Pic> map) {
        super(value, printer, map);
    }

    @Override
    public void show() {
        Pic pic = map.apply(value);
        for (String s : pic.value()) {
            printer.output(s);
        }
    }
}

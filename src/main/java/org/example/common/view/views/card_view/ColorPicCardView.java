package org.example.common.view.views.card_view;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardSuit;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;

import java.util.function.Function;

public class ColorPicCardView extends CardView<Pic> {
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();

    public ColorPicCardView(Card value, ColorPrinter colorPrinter, Function<Card, Pic> map) {
        super(value, colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show() {
        Pic pic = map.apply(value);
        ColorPrinter.Color color = colorMapper.apply(value.getSuit().getColor());

        for (String s : pic.value()) {
            colorPrinter.colorOutput(color, s);
        }
    }

}

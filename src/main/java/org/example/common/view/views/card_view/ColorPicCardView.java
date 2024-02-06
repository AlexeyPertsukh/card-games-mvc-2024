package org.example.common.view.views.card_view;

import org.example.common.model.card.Card;
import org.example.common.model.card.CardSuit;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;

import java.util.function.Function;

public class ColorPicCardView extends CardView<String[]> {
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorMapper = new SuitToPrintColorMapper();

    public ColorPicCardView(Card value, ColorPrinter colorPrinter, Function<Card, String[]> map) {
        super(value, colorPrinter, map);
        this.colorPrinter = colorPrinter;
    }

    @Override
    public void show() {
        String[] picture = map.apply(value);
        ColorPrinter.Color color = colorMapper.apply(value.getSuit().getColor());

        for (String s : picture) {
            colorPrinter.colorOutput(color, s);
        }
    }

}

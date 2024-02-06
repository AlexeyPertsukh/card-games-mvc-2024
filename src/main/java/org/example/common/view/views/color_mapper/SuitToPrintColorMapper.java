package org.example.common.view.views.color_mapper;

import org.example.common.model.card.CardSuit;
import org.example.common.view.printer.ColorPrinter;

import java.util.function.Function;

public class SuitToPrintColorMapper implements Function<CardSuit.Color, ColorPrinter.Color> {
    @Override
    public ColorPrinter.Color apply(CardSuit.Color color) {
        switch (color){
            case BLACK:return ColorPrinter.Color.GREEN;
            case RED:return ColorPrinter.Color.RED;
            default: throw new IllegalArgumentException("illegal CardSuit.Color: " + color);
        }
    }
}

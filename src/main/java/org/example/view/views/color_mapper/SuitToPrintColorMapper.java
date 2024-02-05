package org.example.view.views.color_mapper;

import org.example.model.card.CardSuit;
import org.example.view.views.printer.ColorPrinter;

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

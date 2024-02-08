package org.example.common.view.views.table_view;

import org.example.common.view.views.color_mapper.SuitToPrintColorMapper;
import org.example.common.model.card.Card;
import org.example.common.model.card.CardSuit;
import org.example.common.view.printer.ColorPrinter;

import java.util.List;
import java.util.function.Function;

public class ColorTextTableView extends AbstractTextTableView{
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorNapper = new SuitToPrintColorMapper();
    public ColorTextTableView(List<org.example.common.model.deck.Deck> value, ColorPrinter colorPrinter, Function<Card, String> mapper) {
        super(value, colorPrinter, mapper);
        this.colorPrinter = colorPrinter;
    }

    @Override
    protected void showLine(List<org.example.common.model.deck.Deck> decks, int line) {
        for (org.example.common.model.deck.Deck deck : decks) {
            String text = EMPTY;
            ColorPrinter.Color color = ColorPrinter.Color.DEFAULT;

            if (deck.size() > line) {
                Card card = deck.get(line);
                text = text(card);
                if(card.isOpen()) {
                    color = color(card);
                }
            }
            text = String.format(TEMPLATE, text);
            colorPrinter.colorOut(color, text);
        }
        printer.output();
    }

    private ColorPrinter.Color color(Card deck) {
        if(!deck.isOpen()) {
            return ColorPrinter.Color.DEFAULT;
        }
        return colorNapper.apply(deck.getSuit().getColor());
    }

}

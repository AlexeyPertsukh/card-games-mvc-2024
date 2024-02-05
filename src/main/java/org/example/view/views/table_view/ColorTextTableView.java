package org.example.view.views.table_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.card.CardSuit;
import org.example.view.views.color_mapper.SuitToPrintColorMapper;
import org.example.view.views.printer.ColorPrinter;
import org.example.view.views.printer.Printer;

import java.util.List;
import java.util.function.Function;

public class ColorTextTableView extends AbstractTextTableView{
    private final ColorPrinter colorPrinter;
    private final Function<CardSuit.Color, ColorPrinter.Color> colorNapper = new SuitToPrintColorMapper();
    public ColorTextTableView(ColorPrinter colorPrinter, Function<Card, String> mapper) {
        super(colorPrinter, mapper);
        this.colorPrinter = colorPrinter;
    }

    @Override
    protected void showLine(List<Deck> decks, int line) {
        for (Deck deck : decks) {
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

    private ColorPrinter.Color color(Card card) {
        if(!card.isOpen()) {
            return ColorPrinter.Color.DEFAULT;
        }
        return colorNapper.apply(card.getSuit().getColor());
    }

}

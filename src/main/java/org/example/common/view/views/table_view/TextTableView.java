package org.example.common.view.views.table_view;

import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public class TextTableView extends AbstractTextTableView{
    public TextTableView(List<org.example.common.model.deck.Deck> value, Printer printer, Function<Card, String> mapper) {
        super(value, printer, mapper);
    }

    @Override
    protected void showLine(List<org.example.common.model.deck.Deck> decks, int line) {
        for (org.example.common.model.deck.Deck deck : decks) {
            String text = EMPTY;
            if (deck.size() > line) {
                Card card = deck.get(line);
                text = text(card);
            }
            text = String.format(TEMPLATE, text);
            printer.out(text);
        }
        printer.output();
    }
}

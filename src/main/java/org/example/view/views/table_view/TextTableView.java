package org.example.view.views.table_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.views.printer.Printer;

import java.util.List;
import java.util.function.Function;

public class TextTableView extends AbstractTextTableView{
    public TextTableView(Printer printer, Function<Card, String> mapper) {
        super(printer, mapper);
    }

    @Override
    protected void showLine(List<Deck> decks, int line) {
        for (Deck deck : decks) {
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

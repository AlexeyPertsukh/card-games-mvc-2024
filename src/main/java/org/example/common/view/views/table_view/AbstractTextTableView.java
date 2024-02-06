package org.example.common.view.views.table_view;

import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.view.printer.Printer;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractTextTableView extends TableView<String> {
    protected static final String HIDDEN = "<hidden>";
    protected static final String EMPTY = "";
    protected final static String TEMPLATE = "%-20s";

    public AbstractTextTableView(List<Deck> value, Printer printer, Function<Card, String> mapper) {
        super(value, printer, mapper);
    }

    @Override
    public void show() {
        int max = max(value);
        for (int i = 0; i < max; i++) {
            showLine(value, i);
        }
    }

    protected abstract void showLine(List<Deck> decks, int line);

    protected String text(Card card) {
        return card.isOpen() ? mapper.apply(card) : HIDDEN;
    }

    public String template() {
        return TEMPLATE;
    }

    protected static int max(List<Deck> decks) {
        int max = 0;
        for (Deck deck : decks) {
            if (deck.size() > max) {
                max = deck.size();
            }
        }
        return max;
    }
}

package org.example.view.views.table_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.view.views.printer.Printer;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractTextTableView extends TableView<String> {
    protected static final String HIDDEN = "<hidden>";
    protected static final String EMPTY = "";
    protected final static String TEMPLATE = "%-20s";

    public AbstractTextTableView(Printer printer, Function<Card, String> mapper) {
        super(printer, mapper);
    }

    @Override
    public void show(List<Deck> decks) {
        int max = max(decks);
        for (int i = 0; i < max; i++) {
            showLine(decks, i);
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

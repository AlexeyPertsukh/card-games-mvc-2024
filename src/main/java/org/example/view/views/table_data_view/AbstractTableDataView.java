package org.example.view.views.table_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.PlayerStatus;
import org.example.view.views.printer.Printer;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractTableDataView<T> extends TableDataView<T>{
    private static final String HIDDEN = "<hidden>";

    public AbstractTableDataView(Printer printer, Function<Card, T> map) {
        super(printer, map);
    }

    protected static String text(PlayerStatus state) {
        switch (state) {
            case BLACK_JACK: return "BLACK JACK";
            case BUST: return "BUST";
            case LOSE: return "LOSE";
            case WIN: return "WIN";
            case IN_GAME: return "in game";
            default: throw new IllegalArgumentException("illegal game state: " + state);
        }
    }

    protected static String text(Card card) {
        if(card.isOpen()) {
            return String.format("%s %s", card.getSuit().getIcon(), card.getRank().getLabel());
        }
        return HIDDEN;
    }

    protected int max(List<Deck> decks) {
        int max = 0;
        for (Deck deck : decks) {
            if (deck.size() > max) {
                max = deck.size();
            }
        }
        return max;
    }
}

package org.example.controller;

import org.example.model.Deck;
import org.example.model.deck_factory.DeckFactory;
import org.example.model.deck_factory.DeckFactory54CardRandom;
import org.example.view.card_mapper.TextCardMapper;
import org.example.view.views.View;
import org.example.view.views.printer.ColorConsolePrinter;
import org.example.view.views.printer.ConsolePrinter;
import org.example.view.views.printer.Printer;
import org.example.view.views.reader.KeyboardReader;
import org.example.view.views.reader.Reader;
import org.example.view.views.table_view.AbstractTextTableView;
import org.example.view.views.table_view.ColorTextTableView;
import org.example.view.views.table_view.MonoTextTableView;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        Printer printer = new ConsolePrinter();
        Reader reader = new KeyboardReader();

        DeckFactory factory = new DeckFactory54CardRandom(3);
        List<Deck> decks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Deck deck = factory.get();
            deck.open();
            if(i == 1) {
                Deck second = factory.get();
                deck.add(second.take());
            }
            decks.add(deck);
        }

        View<List<Deck>> view = new ColorTextTableView(new ColorConsolePrinter(), TextCardMapper.getInstance());
        view.show(decks);

    }
}

package org.example.black_jack.controller;

import org.example.black_jack.model.BjPointCounter;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.view.card_mapper.CardMapper;
import org.example.common.view.factory.card_mapper_factory.PicCardMapperFactory;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorConsolePrinter;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.View;
import org.example.common.view.views.deck_view.ColorPicDeckView;

import static org.example.common.model.card.CardRank.*;
import static org.example.common.model.card.CardSuit.*;

public class MainTest {
    public static void main(String[] args) {
        ColorPrinter colorPrinter = new ColorConsolePrinter();
        Reader reader = new KeyboardReader();
        BjPointCounter counter = new BjPointCounter();
        CardMapper<Pic> mapper = (new PicCardMapperFactory()).get(PicCardMapperFactory.Type.MINI_5X3);

        Deck deck = new Deck();

        for (int i = 0; i < 3; i++) {
            Card card = i == 0 ? new Card(TEN, DIAMOND) : new Card(ACE, DIAMOND);
            card.open();
            deck.add(card);
        }

        View view = new ColorPicDeckView(deck, colorPrinter, mapper);
        view.show();

        int point = counter.apply(deck);

        colorPrinter.output(String.valueOf(point));

    }
}

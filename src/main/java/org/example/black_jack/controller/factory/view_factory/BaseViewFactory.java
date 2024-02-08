package org.example.black_jack.controller.factory.view_factory;

import org.example.black_jack.model.game.PlayerData;
import org.example.black_jack.view.player_data_view.TextPdataView;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.View;
import org.example.common.view.views.card_view.PicCardView;
import org.example.common.view.views.deck_view.PicDeckView;

import java.util.List;
import java.util.function.Function;

public class BaseViewFactory extends AbstractViewFactory {
    private final Function<Card, String> textCardMapper;
    private final Function<Card, Pic> picCardMapper;
    private final Printer printer = new ConsolePrinter();
    private final Reader reader = new KeyboardReader();

    public BaseViewFactory(Function<Card, String> textCardMapper, Function<Card, Pic> picCardMapper) {
        this.textCardMapper = textCardMapper;
        this.picCardMapper = picCardMapper;
    }

    @Override
    public View tittle() {
        return new MemoInfoView(TITTLE, printer);
    }

    @Override
    public View infoEnd() {
        return new InfoView(END_MESSAGE, printer);
    }

    @Override
    public View infoText(String text) {
        return new InfoView(text, printer);
    }

    @Override
    public View infoAddCard(Player player) {
        String text = String.format(ADD_CARDS_TEMPLATE, player.getName());
        return new InfoView(text, printer);
    }

    @Override
    public View infoDealerShowCards() {
        return new InfoView(DEALER_REVEALS_MESSAGE, printer);
    }

    @Override
    public View playerData(List<PlayerData> data) {
        return new TextPdataView(data, printer, textCardMapper);
    }

    @Override
    public View picCardView(Card card) {
        return new PicCardView(card, printer, picCardMapper);
    }

    @Override
    public View picDeckView(Deck deck) {
        return new PicDeckView(deck, printer, picCardMapper);
    }

}

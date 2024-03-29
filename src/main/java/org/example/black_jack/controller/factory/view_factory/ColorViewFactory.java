package org.example.black_jack.controller.factory.view_factory;

import org.example.black_jack.model.game.PlayerData;
import org.example.black_jack.view.player_data_view.ColorTextPdataView;
import org.example.common.model.card.Card;
import org.example.common.model.player.Player;
import org.example.common.view.info_view.ColorInfoView;
import org.example.common.view.info_view.ColorMemoInfoView;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.info_view.MemoInfoView;
import org.example.common.view.pic.Pic;
import org.example.common.view.printer.ColorConsolePrinter;
import org.example.common.view.printer.ColorPrinter;
import org.example.common.view.views.View;
import org.example.common.view.views.card_view.ColorPicCardView;
import org.example.common.view.views.deck_view.ColorPicDeckView;

import java.util.List;
import java.util.function.Function;

public class ColorViewFactory extends AbstractViewFactory {
    private final static ColorPrinter.Color COLOR_TITTLE = ColorPrinter.Color.BLUE;
    private final static ColorPrinter.Color COLOR_END = ColorPrinter.Color.PURPLE;
    private final static ColorPrinter.Color COLOR_GAME_RESULT = ColorPrinter.Color.BLUE;
    private final Function<Card, String> textCardMapper;
    private final Function<Card, Pic> picCardMapper;
    private final ColorPrinter printer = new ColorConsolePrinter();

    public ColorViewFactory(Function<Card, String> textCardMapper, Function<Card, Pic> picCardMapper) {
        this.textCardMapper = textCardMapper;
        this.picCardMapper = picCardMapper;
    }

    @Override
    public View tittle() {
        return new ColorMemoInfoView(TITTLE, printer, COLOR_TITTLE);
    }

    @Override
    public View infoEnd() {
        return new ColorInfoView(END_MESSAGE, printer, COLOR_END);
    }

    @Override
    public View infoText(String text) {
        return new InfoView(text, printer);
    }

    @Override
    public View infoAddCard(String name) {
        String text = String.format(ADD_CARDS_TEMPLATE, name);
        return new InfoView(text, printer);
    }

    @Override
    public View infoDealerShowCards() {
        return new InfoView(DEALER_REVEALS_MESSAGE, printer);
    }

    @Override
    public View infoBotCmdInput(String name, String keyTake, String keySkip) {
        String text = String.format(DIALOG_INPUT_CMD_TEMPLATE, name, keyTake, keySkip);
        return new InfoView(text, printer);
    }

    @Override
    public View infoGameResult() {
        return new ColorMemoInfoView(MESSAGE_GAME_RESULT, printer, COLOR_GAME_RESULT);
    }

    @Override
    public View infoHelp() {
        return null;//TODO
    }

    @Override
    public View playerData(List<PlayerData> data) {
        return new ColorTextPdataView(data, printer, textCardMapper);
    }

    @Override
    public View picDeckView(org.example.common.model.deck.Deck deck) {
        return new ColorPicDeckView(deck, printer, picCardMapper);
    }

}

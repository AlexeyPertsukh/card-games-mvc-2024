package org.example.black_jack.controller.factory;

import org.example.black_jack.controller.game.PlayerData;
import org.example.black_jack.view.player_data_view.TextPdataView;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.SelectStringDialogView;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.info_view.StringsInfoView;
import org.example.common.view.printer.ConsolePrinter;
import org.example.common.view.printer.Printer;
import org.example.common.view.reader.KeyboardReader;
import org.example.common.view.reader.Reader;
import org.example.common.view.views.View;
import org.example.common.view.views.card_view.PicCardView;
import org.example.common.view.views.deck_view.PicDeckView;
import org.example.common.view.views.deck_view.TextDeckView;

import java.util.List;
import java.util.function.Function;

public class MonoViewFactory extends AbstractViewFactory {
    private final Function<Card, String> textCardMapper;
    private final Function<Card, String[]> picCardMapper;
    private final Printer printer = new ConsolePrinter();
    private final Reader reader = new KeyboardReader();

    public MonoViewFactory(Function<Card, String> textCardMapper, Function<Card, String[]> picCardMapper) {
        this.textCardMapper = textCardMapper;
        this.picCardMapper = picCardMapper;
    }

    @Override
    public View tittle() {
        return new StringsInfoView(TITTLE, printer);
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

    //DIALOGS
    @Override
    public DialogView<String> dialogStart() {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format("Press '%s' to start game", key);
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                "",
                key
        );
    }

    @Override
    public DialogView<String> dialogBeginCardDealOver() {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format("Initial card deal is over, press '%s' to continue", key);
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                "",
                key
        );
    }

    @Override
    public DialogView<String> dialogBust(String name) {
        String key = DEFAULT_CONTINUE_KEY;
        String tittle = String.format(BUST_MESSAGE_TEMPLATE,
                name,
                key
        );
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                key
        );
    }

    @Override
    public DialogView<String> dialogPlayerInput(String name, String keyTake, String keySkip) {
        String tittle = String.format("[%s] input command: %s - take card, %s - skip",
                name,
                keyTake,
                keySkip
        );
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                keyTake,
                keySkip
        );
    }

    public DialogView<String> dialogPressToContinue() {
        String key = DEFAULT_CONTINUE_KEY;
        final String tittle = String.format(BASIC_PRESS_TO_CONTINUE_TEMPLATE, key);
        return new SelectStringDialogView(
                printer,
                reader,
                tittle,
                DIALOG_ERROR_MESSAGE,
                key
        );
    }

}

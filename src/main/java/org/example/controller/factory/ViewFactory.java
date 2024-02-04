package org.example.controller.factory;

import org.example.model.card.Card;
import org.example.model.player.Player;
import org.example.view.Printer;
import org.example.view.card_mapper.CardMapper;
import org.example.view.card_mapper.SmallStringsCardMapper;
import org.example.view.card_mapper.TextCardMapper;
import org.example.view.info_view.InfoView;
import org.example.view.info_view.StringsInfoView;
import org.example.view.info_view.TextInfoView;
import org.example.view.views.View;
import org.example.view.views.deck_view.StringsDeckView;
import org.example.view.views.group_player_data_view.TextListPlayerDataView;

import java.util.function.Function;

public class ViewFactory {
    private static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };

    private static final String END_MESSAGE = "END GAME";


    private final Printer printer;
    private final CardMapper<String> textCardMapper = TextCardMapper.getInstance();
    private final CardMapper<String[]> stringsCardMapper = SmallStringsCardMapper.getInstance();

    public ViewFactory(Printer printer) {
        this.printer = printer;
    }



    public InfoView infoTittle() {
        return new StringsInfoView(
                printer,
                TITTLE
        );
    }

    public InfoView infoEnd() {
        return new TextInfoView(
                printer,
                END_MESSAGE
        );
    }

    public InfoView infoDealerShowCards() {
        return new TextInfoView(
                printer,
                "the dealer reveals his cards"
        );
    }

    public InfoView infoAddCard(Player player) {
        String text = String.format("[%s] receives cards", player.getName());
        return new TextInfoView(printer, text);
    }

//    public View<Deck> deckView() {
    public View deckView() {
        return new StringsDeckView(
                printer,
                stringsCardMapper
        );
    }

    public View tableView() {
        return new TextListPlayerDataView(
                printer,
                textCardMapper
        );
    }


}

package org.example.controller.factory;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.player.Player;
import org.example.view.views.printer.Printer;
import org.example.view.card_mapper.CardMapper;
import org.example.view.info_view.InfoView;
import org.example.view.info_view.StringsInfoView;
import org.example.view.info_view.TextInfoView;
import org.example.view.views.View;
import org.example.view.views.card_view.StringsCardView;
import org.example.view.views.group_player_data_view.TextListPlayerDataView;

public class ViewFactory {
    private static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };

    private static final String END_MESSAGE = "END GAME";


    private final Printer printer;
    private final CardMapper<String> textCardMapper;
    private final CardMapper<String[]> stringsCardMapper;
    private final View<Deck> deckView;
    private final View<Card> cardView;


    public ViewFactory(Printer printer, CardMapper<String> textCardMapper, CardMapper<String[]> stringsCardMapper, View<Deck> deckView, View<Card> cardView) {
        this.printer = printer;
        this.textCardMapper = textCardMapper;
        this.stringsCardMapper = stringsCardMapper;
        this.deckView = deckView;
        this.cardView = cardView;
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

    public InfoView infoText(String text) {
        return new TextInfoView(
                printer,
                text
        );
    }

    public InfoView infoAddCard(Player player) {
        String text = String.format("[%s] receives cards", player.getName());
        return new TextInfoView(printer, text);
    }

//    public View<Deck> deckView() {
    public View deckView() {
//        return new StringsDeckView(
//                printer,
//                stringsCardMapper
//        );
        return deckView;
    }

    public View cardView() {
        return cardView;
    }

    public View tableView() {
        return new TextListPlayerDataView(
                printer,
                textCardMapper
        );
    }


}

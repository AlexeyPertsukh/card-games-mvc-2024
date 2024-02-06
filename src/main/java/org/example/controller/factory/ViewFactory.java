package org.example.controller.factory;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.game.PlayerData;
import org.example.model.player.Player;
import org.example.view.printer.Printer;
import org.example.view.info_view.InfoView;
import org.example.view.info_view.StringsInfoView;
import org.example.view.info_view.TextInfoView;
import org.example.view.views.View;

import java.util.List;

public class ViewFactory {
    private static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };

    private static final String END_MESSAGE = "END GAME";


    private final Printer printer;
    private final View<Deck> deckView;
    private final View<Card> cardView;
    private final View<List<PlayerData>> tableView;


    public ViewFactory(Printer printer, View<Deck> deckView, View<Card> cardView,View<List<PlayerData>> tableView) {
        this.printer = printer;
        this.deckView = deckView;
        this.cardView = cardView;
        this.tableView = tableView;
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
        return tableView;
    }


}

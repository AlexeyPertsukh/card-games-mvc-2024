package org.example.black_jack.controller.factory;

import org.example.black_jack.controller.game.PlayerData;
import org.example.common.model.deck.Deck;
import org.example.common.model.card.Card;
import org.example.common.model.player.Player;
import org.example.common.view.printer.Printer;
import org.example.common.view.info_view.StringsInfoView;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.views.View;

import java.util.List;

public class OldViewFactory {
    private static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };

//    private static final String END_MESSAGE = "END GAME";
//
//
//    private final Printer printer;
//    private final View<Deck> deckView;
//    private final View<Card> cardView;
//    private final View<List<PlayerData>> tableView;
//
//
//    public OldViewFactory(Printer printer, View<Deck> deckView, View<Card> cardView, View<List<PlayerData>> tableView) {
//        this.printer = printer;
//        this.deckView = deckView;
//        this.cardView = cardView;
//        this.tableView = tableView;
//    }
//
//
//
//    public InfoView infoTittle() {
//        return new StringsInfoView(
//                printer,
//                TITTLE
//        );
//    }
//
//    public InfoView infoEnd() {
//        return new InfoView(
//                printer,
//                END_MESSAGE
//        );
//    }
//
//    public InfoView infoDealerShowCards() {
//        return new InfoView(
//                printer,
//                "the dealer reveals his cards"
//        );
//    }
//
//    public InfoView infoText(String text) {
//        return new InfoView(
//                printer,
//                text
//        );
//    }
//
//    public InfoView infoAddCard(Player player) {
//        String text = String.format("[%s] receives cards", player.getName());
//        return new InfoView(printer, text);
//    }
//
////    public View<Deck> deckView() {
//    public View deckView() {
////        return new StringsDeckView(
////                printer,
////                stringsCardMapper
////        );
//        return deckView;
//    }
//
//    public View cardView() {
//        return cardView;
//    }
//
//    public View tableView(List<PlayerData> list) {
//        return tableView;
//    }


}

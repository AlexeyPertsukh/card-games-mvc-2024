package org.example.black_jack.controller.factory;

import org.example.black_jack.controller.game.PlayerData;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.view.dialog_view.DialogView;
import org.example.common.view.dialog_view.SelectStringDialogView;
import org.example.common.view.views.View;

import java.util.List;

public interface ViewFactory {
    View tittle();
    View infoEnd();
    View infoAddCard(Player player);
    View infoText(String text);
    View infoDealerShowCards();


    View playerData(List<PlayerData> data);
    View picCardView(Card card);
    View picDeckView(Deck deck);

    DialogView<String> dialogStart();
    DialogView<String> dialogBeginCardDealOver();
    DialogView<String> dialogBust(String name);
    DialogView<String> dialogPlayerInput(String name, String keyTake, String keySkip);
    DialogView<String> dialogPressToContinue();

}

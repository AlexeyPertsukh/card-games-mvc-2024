package org.example.black_jack.controller.factory.view_factory;

import org.example.black_jack.model.game.PlayerData;
import org.example.common.model.card.Card;
import org.example.common.model.deck.Deck;
import org.example.common.model.player.Player;
import org.example.common.view.views.View;

import java.util.List;

public interface ViewFactory {
    View tittle();
    View infoEnd();
    View infoAddCard(String name);
    View infoText(String text);
    View infoDealerShowCards();
    View infoBotCmdInput(String name, String keyTake, String keySkip);
    View infoGameResult();
    View infoHelp();


    View playerData(List<PlayerData> data);
    View picDeckView(Deck deck);

}

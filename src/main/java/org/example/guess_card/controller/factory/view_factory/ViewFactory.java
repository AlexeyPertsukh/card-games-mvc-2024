package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.model.player.Player;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.views.View;
import org.example.guess_card.model.GcStorage;

import java.util.List;

public interface ViewFactory {
    View tittle();
    View help();
    View card(Card card);
    View data(List<GcStorage.Data> value);
    View win(GcStorage.Data data);
}

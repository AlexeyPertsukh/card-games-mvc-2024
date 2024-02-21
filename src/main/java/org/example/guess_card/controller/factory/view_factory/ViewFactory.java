package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.view.views.View;
import org.example.guess_card.model.storage.GcStorage;
import org.example.guess_card.model.PointCounter;
import org.example.guess_card.model.rules.Rules;

import java.util.List;

public interface ViewFactory {
    View tittle();
    View help(Rules rules, PointCounter counter);
    View card(Card card);
    View data(List<GcStorage.Data> value);
    View win(GcStorage.Data data);
}

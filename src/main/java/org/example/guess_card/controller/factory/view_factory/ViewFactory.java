package org.example.guess_card.controller.factory.view_factory;

import org.example.common.model.card.Card;
import org.example.common.view.info_view.InfoView;
import org.example.common.view.views.View;

public interface ViewFactory {
    View tittle();
    View card(Card card);
}

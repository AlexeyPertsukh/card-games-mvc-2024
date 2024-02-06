package org.example.black_jack.controller.player_data;

import org.example.common.model.deck.Deck;
import org.example.black_jack.model.Rules;
import org.example.common.model.card.Card;
import org.example.black_jack.controller.game.PlayerData;
import org.example.black_jack.controller.game.PlayerStatus;
import org.example.common.model.point_counter.PointCounter;

import java.util.List;

public class PlayerDataUpdater {
    private final Rules rules;
    private final PointCounter counter;

    public PlayerDataUpdater(Rules rules, PointCounter counter) {
        this.rules = rules;
        this.counter = counter;
    }

    public void update(PlayerData data) {
        Deck deck = data.getDeck();

        Deck deckOpenCards = deckOpenCards(deck);
        int point = counter.apply(deckOpenCards);
    }

    private Deck deckOpenCards(Deck deck) {
        Deck out = new Deck();
        List<Card> cards = deck.toList();
        for (Card card : cards) {
            if (card.isOpen()) {
                out.add(card);
            }
        }
        return out;
    }

    private PlayerStatus state(boolean isOpen, int point) {
        if (rules.isBust(point)) {
            return PlayerStatus.BUST;
        }

        if (!isOpen) {
            return PlayerStatus.IN_GAME;
        }

//        if(rules.isBlackJack(data.getDeck().size(), point)) {
//            return GameState.BLACK_JACK;
//        }
//        if(rules.isLose(winPoint, point)) {
//            return GameState.LOSE;
//        }
//        if(rules.isWin(winPoint, point)) {
//            return GameState.WIN;
//        }
        return PlayerStatus.IN_GAME;
    }
}

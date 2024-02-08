package org.example.black_jack.model.game;

import org.example.black_jack.model.Rules;
import org.example.common.model.deck.Deck;
import org.example.common.model.point_counter.PointCounter;

import java.util.ArrayList;
import java.util.List;

public class DataUpdater {
    private final Rules rules;
    private final PointCounter counter;

    public DataUpdater(Rules rules, PointCounter counter) {
        this.rules = rules;
        this.counter = counter;
    }

    public void updateOnWork(PlayerData data) {
        Deck deck = data.getDeck();
//        deck.sort(comparator);
        int point = counter.apply(deck);
        data.setPoint(point);


        if (rules.isBust(point)) {
            data.setStatus(PlayerStatus.BUST);
            return;
        }
        if (rules.isBlackJack(deck.size(), point)) {
            data.setStatus(PlayerStatus.BLACK_JACK);
            return;
        }
        if (rules.isMaxWinPoint(point)) {
            data.setStatus(PlayerStatus.WIN);
            return;
        }

    }

    public void updateResult(List<PlayerData> list, int dealerPoint) {
        List<Integer> points = pointList(list);
        int winPoint = rules.winPoint(points);

        for (PlayerData data : list) {
            updateResult(data, winPoint, dealerPoint);
        }
    }

    private void updateResult(PlayerData data, int winPoint, int dealerPoint) {
        Deck deck = data.getDeck();
        int point = data.getPoint();

        if(rules.isPush(winPoint, point, dealerPoint)) {
            data.setStatus(PlayerStatus.PUSH);
            return;
        }

        if (rules.isBust(point)) {
            data.setStatus(PlayerStatus.BUST);
            return;
        }

        if (rules.isBlackJack(deck.size(), point)) {
            data.setStatus(PlayerStatus.BLACK_JACK);
            return;
        }

        if (rules.isWin(winPoint, point)) {
            data.setStatus(PlayerStatus.WIN);
            return;
        }

        if (rules.isLose(winPoint, point)) {
            data.setStatus(PlayerStatus.LOSE);
            return;
        }

        throw new IllegalArgumentException("bug in result game data update");
    }

    private List<Integer> pointList(List<PlayerData> list) {
        List<Integer> points = new ArrayList<>();
        for (PlayerData data : list) {
            points.add(data.getPoint());
        }
        return points;
    }


}

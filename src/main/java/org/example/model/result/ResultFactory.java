package org.example.model.result;

import org.example.model.Deck;
import org.example.model.DeckStorage;
import org.example.model.Rules;
import org.example.model.point_counter.PointCounter;
import org.example.view.Player;

import java.util.ArrayList;
import java.util.List;

public class ResultFactory {
    private final Rules rules;
    private final PointCounter pointCounter;

    public ResultFactory(Rules rules, PointCounter pointCounter) {
        this.rules = rules;
        this.pointCounter = pointCounter;
    }

    public List<Result> create(DeckStorage storage) {
        List<Result> results = new ArrayList<>();
        List<Deck> decks = storage.decks();
        List<Integer> points = points(decks);
        int winPoint = rules.winPoint(points);

        List<Player> players = storage.players();
        for (Player player : players) {
            Deck deck = storage.get(player);
            int point = pointCounter.count(deck);
            Result.State state = toState(winPoint, point);

            Result result = new Result(player, point, state);
            results.add(result);
        }
        return results;
    }

    private Result.State toState(int winPoint, int point) {
        if (rules.isBust(point)) {
            return Result.State.BUST;
        }
        if (rules.isWin(winPoint, point)) {
            return Result.State.WIN;
        }
        return Result.State.LOSE;
    }

    private List<Integer> points(List<Deck> decks) {
        List<Integer> points = new ArrayList<>();
        for (Deck deck: decks             ) {
            int point = pointCounter.count(deck);
            points.add(point);
        }
        return points;

    }


}

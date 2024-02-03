package org.example.model;

import java.util.List;

public class Rules {
    private static final int MAX_WIN_POINT = 21;
    private static final int BLACK_JACK_CARD_NUMBERS = 3;
    private static Rules rules;

    private Rules() {
    }

    public static Rules getInstance() {
        if (rules == null) {
            rules = new Rules();
        }
        return rules;
    }

    public boolean isBust(int point) {
        return point > MAX_WIN_POINT;
    }

    public boolean isWin(int winPoint, int point) {
        return point == winPoint;
    }

    public boolean isLose(int winPoint, int point) {
        return point < winPoint;
    }

    public boolean isBlackJack(int cardNumbers, int point) {
        return cardNumbers == BLACK_JACK_CARD_NUMBERS && point == MAX_WIN_POINT;
    }

    public int winPoint(List<Integer> numbers) {
        int max = 0;
        for (int number : numbers) {
            if (number >= max && number <= MAX_WIN_POINT) {
                max = number;
            }
        }
        return max;
    }

}

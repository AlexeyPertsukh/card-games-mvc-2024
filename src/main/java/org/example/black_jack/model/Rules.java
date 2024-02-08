package org.example.black_jack.model;

import java.util.List;

public class Rules {
    private static final int MAX_WIN_POINT = 21;
    private static final int BLACK_JACK_CARD_NUMBERS = 2;

    public boolean isBust(int point) {
        return point > MAX_WIN_POINT;
    }

    public boolean isWin(int winPoint, int point) {
        return point == winPoint;
    }

    public boolean isLose(int winPoint, int point) {
        return point < winPoint;
    }

    public boolean isBlackJack(int cardsNumber, int point) {
        return cardsNumber == BLACK_JACK_CARD_NUMBERS && point == MAX_WIN_POINT;
    }

    public boolean isMaxWinPoint(int point) {
        return point == MAX_WIN_POINT;
    }

    public boolean isPush(int winPoint, int point, int dealerPoint) {
        return (point == winPoint) && (point==dealerPoint);
    }

    public int winPoint(List<Integer> numbers) {
        int max = 0;
        for (int num : numbers) {
            if (num >= max && num <= MAX_WIN_POINT) {
                max = num;
            }
        }
        return max;
    }


}

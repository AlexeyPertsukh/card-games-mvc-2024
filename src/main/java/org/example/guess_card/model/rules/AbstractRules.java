package org.example.guess_card.model.rules;

public abstract class AbstractRules implements Rules{
    @Override
    public boolean isWin(int point) {
        return point>= winPoint();
    }
}

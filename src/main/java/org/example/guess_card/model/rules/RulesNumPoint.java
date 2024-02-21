package org.example.guess_card.model.rules;

public class RulesNumPoint extends AbstractRules {
    private final int winPoint;

    public RulesNumPoint(int winPoint) {
        this.winPoint = winPoint;
    }

    @Override
    public int winPoint() {
        return winPoint;
    }

}

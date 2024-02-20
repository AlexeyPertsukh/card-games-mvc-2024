package org.example.guess_card.model.bet;

public abstract class AbstractBet<T> implements Bet{
    protected final T value;

    public AbstractBet(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return null;
    }
}

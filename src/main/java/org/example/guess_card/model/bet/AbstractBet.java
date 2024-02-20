package org.example.guess_card.model.bet;

public abstract class AbstractBet<T> implements Bet{
    protected final T value;
    protected final String description;

    public AbstractBet(T value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public T get() {
        return null;
    }
    @Override
    public String getDescription() {
        return description;
    }
}

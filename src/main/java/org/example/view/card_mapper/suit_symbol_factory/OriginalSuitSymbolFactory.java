package org.example.view.card_mapper.suit_symbol_factory;

public final class OriginalSuitSymbolFactory implements SuitSymbolFactory{
    private static final String DIAMOND = "♦";
    private static final String HEART = "♥";
    private static final String SPADE = "♠";
    private static final String CLUB = "♣";

    @Override
    public String diamond() {
        return DIAMOND;
    }

    @Override
    public String heart() {
        return HEART;
    }

    @Override
    public String club() {
        return CLUB;
    }

    @Override
    public String spade() {
        return SPADE;
    }
}

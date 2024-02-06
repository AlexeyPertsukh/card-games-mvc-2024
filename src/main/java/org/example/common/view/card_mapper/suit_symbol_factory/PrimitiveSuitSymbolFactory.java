package org.example.common.view.card_mapper.suit_symbol_factory;

public final class PrimitiveSuitSymbolFactory implements SuitSymbolFactory{

    private static final String DIAMOND = "#";
    private static final String HEART = "v";
    private static final String SPADE = "^";
    private static final String CLUB = "*";


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

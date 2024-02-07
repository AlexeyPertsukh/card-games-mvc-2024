package org.example.common.view.card_mapper;

import org.example.common.view.card_mapper.suit_symbol_factory.PrimitiveSuitSymbolFactory;
import org.example.common.view.card_mapper.suit_symbol_factory.SuitSymbolFactory;

public class Small13x7PicCardMapper extends CombainPicCardMapper {
    private final static SuitSymbolFactory symbolFactory = new PrimitiveSuitSymbolFactory();

    public static final String CHANGE_SYMBOL = "$";
    private static final String[] BACK = {
            "┌───────────┐",
            "│░░░░░░░░░░░│",
            "│░░░░░░░░░░░│",
            "│░░░░░░░░░░░│",
            "│░░░░░░░░░░░│",
            "│░░░░░░░░░░░│",
            "└───────────┘",
    };

    private static final String[] JOKER = {
            "┌───────────┐",
            "│$ JOKER    │",
            "│           │",
            "│           │",
            "│           │",
            "│    JOKER $│",
            "└───────────┘",
    };
    private static final String[] TWO = {
            "┌───────────┐",
            "│ 2         │",
            "│     $     │",
            "│           │",
            "│     $     │",
            "│         2 │",
            "└───────────┘",
    };

    private static final String[] THREE = {
            "┌───────────┐",
            "│ 3         │",
            "│     $     │",
            "│     $     │",
            "│     $     │",
            "│         3 │",
            "└───────────┘",
    };

    private static final String[] FOUR = {
            "┌───────────┐",
            "│ 4         │",
            "│  $     $  │",
            "│           │",
            "│  $     $  │",
            "│         4 │",
            "└───────────┘",
    };

    private static final String[] FIVE = {
            "┌───────────┐",
            "│ 5         │",
            "│  $     $  │",
            "│     $     │",
            "│  $     $  │",
            "│         5 │",
            "└───────────┘",
    };


    private static final String[] SIX = {
            "┌───────────┐",
            "│ 6         │",
            "│  $  $  $  │",
            "│           │",
            "│  $  $  $  │",
            "│         6 │",
            "└───────────┘",
    };

    private static final String[] SEVEN = {
            "┌───────────┐",
            "│ 7         │",
            "│  $  $  $  │",
            "│     $     │",
            "│  $  $  $  │",
            "│         7 │",
            "└───────────┘",
    };

    private static final String[] EIGHT = {
            "┌───────────┐",
            "│ 8         │",
            "│  $  $  $  │",
            "│   $   $   │",
            "│  $  $  $  │",
            "│         8 │",
            "└───────────┘",
    };


    private static final String[] NINE = {
            "┌───────────┐",
            "│ 9         │",
            "│  $  $  $  │",
            "│  $  $  $  │",
            "│  $  $  $  │",
            "│         9 │",
            "└───────────┘",
    };

    private static final String[] TEN = {
            "┌───────────┐",
            "│ 10        │",
            "│  $ $ $ $  │",
            "│    $ $    │",
            "│  $ $ $ $  │",
            "│        10 │",
            "└───────────┘",
    };

    private static final String[] JACK = {
            "┌───────────┐",
            "│ J         │",
            "│           │",
            "│     $     │",
            "│           │",
            "│         J │",
            "└───────────┘",
    };

    private static final String[] QUEEN = {
            "┌───────────┐",
            "│ Q         │",
            "│           │",
            "│     $     │",
            "│           │",
            "│         Q │",
            "└───────────┘",
    };

    private static final String[] KING = {
            "┌───────────┐",
            "│ K         │",
            "│           │",
            "│     $     │",
            "│           │",
            "│         K │",
            "└───────────┘",
    };

    private static final String[] ACE = {
            "┌───────────┐",
            "│ A         │",
            "│           │",
            "│     $     │",
            "│           │",
            "│         A │",
            "└───────────┘",
    };

    private static Small13x7PicCardMapper factory;

    public static Small13x7PicCardMapper getInstance() {
        if(factory == null) {
            factory = new Small13x7PicCardMapper();
        }
        return factory;
    }

    @Override
    protected String changeSymbol() {
        return CHANGE_SYMBOL;
    }

    @Override
    protected String[] back() {
        return BACK;
    }

    @Override
    protected String[] joker() {
        return JOKER;
    }

    @Override
    protected String[] two() {
        return TWO;
    }

    @Override
    protected String[] three() {
        return THREE;
    }

    @Override
    protected String[] four() {
        return FOUR;
    }

    @Override
    protected String[] five() {
        return FIVE;
    }

    @Override
    protected String[] six() {
        return SIX;
    }

    @Override
    protected String[] seven() {
        return SEVEN;
    }

    @Override
    protected String[] eight() {
        return EIGHT;
    }

    @Override
    protected String[] nine() {
        return NINE;
    }

    @Override
    protected String[] ten() {
        return TEN;
    }

    @Override
    protected String[] jack() {
        return JACK;
    }

    @Override
    protected String[] queen() {
        return QUEEN;
    }

    @Override
    protected String[] king() {
        return KING;
    }

    @Override
    protected String[] ace() {
        return ACE;
    }

    @Override
    protected String diamond() {
        return symbolFactory.diamond();
    }

    @Override
    protected String heart() {
        return symbolFactory.heart();
    }

    @Override
    protected String club() {
        return symbolFactory.club();
    }

    @Override
    protected String spade() {
        return symbolFactory.spade();
    }



}

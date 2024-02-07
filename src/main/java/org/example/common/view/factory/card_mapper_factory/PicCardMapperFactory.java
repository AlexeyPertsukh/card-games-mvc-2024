package org.example.common.view.factory.card_mapper_factory;

import org.example.common.view.card_mapper.*;
import org.example.common.view.pic.Pic;

public class PicCardMapperFactory implements CardMapperFactory<Pic> {
    private static final Type DEFAULT = Type.MINI_9X5;
    public CardMapper<Pic> get(Type type) {
        switch (type) {
            case MICRO_1X1:return new Micro1x1PicCardMapper();
            case MINI_2X3:return new Mini2x3PicCardMapper();
            case MINI_4X3:return new Mini4x3PicCardMapper();
            case MINI_5X3:return new Mini5x3PicCardMapper();
//            case MINI_9X5:return new Mini9x5PicCardMapper();
            case MINI_9X5:return new Mini9x5PicVer2CardMapper();
            case SMALL_13X7:return new Small13x7PicCardMapper();
            case LARGE_17X11:return new Large17x11PicCardMapper();
            default: throw new IllegalArgumentException("unsupported card mapper type: " + type);
        }
    }

    @Override
    public CardMapper<Pic> get(int value) {
        Type type = Type.values()[value];
        return get(type);
    }

    @Override
    public CardMapper<Pic> get(String value) {
        Type type = Type.valueOf(value);
        return get(type);
    }

    @Override
    public CardMapper<Pic> get() {
        return get(DEFAULT);
    }

    public enum Type {
        MICRO_1X1,
        MINI_2X3,
        MINI_4X3,
        MINI_5X3,
        MINI_9X5,
        SMALL_13X7,
        LARGE_17X11
    }

}

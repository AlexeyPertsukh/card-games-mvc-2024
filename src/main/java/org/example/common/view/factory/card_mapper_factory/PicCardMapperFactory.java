package org.example.common.view.factory.card_mapper_factory;

import org.example.common.view.card_mapper.*;

public class PicCardMapperFactory implements CardMapperFactory<String[]> {
    private static final Type DEFAULT = Type.MINI;
    public CardMapper<String[]> get(Type type) {
        switch (type) {
            case MICRO:return new MicroPicCardMapper();
            case MINI:return new MiniPicCardMapper();
            case SMALL:return new SmallPicCardMapper();
            case LARGE:return new LargePicCardMapper();
            default: throw new IllegalArgumentException("unsupported card mapper type: " + type);
        }
    }

    @Override
    public CardMapper<String[]> get(int value) {
        Type type = Type.values()[value];
        return get(type);
    }

    @Override
    public CardMapper<String[]> get(String value) {
        Type type = Type.valueOf(value);
        return get(type);
    }

    @Override
    public CardMapper<String[]> get() {
        return get(DEFAULT);
    }

    public enum Type {
        MICRO,
        MINI,
        SMALL,
        LARGE
    }

}

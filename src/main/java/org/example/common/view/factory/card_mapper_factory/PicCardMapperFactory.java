package org.example.common.view.factory.card_mapper_factory;

import org.example.common.view.card_mapper.*;
import org.example.common.view.pic.Pic;

public class PicCardMapperFactory implements CardMapperFactory<Pic> {
    private static final Type DEFAULT = Type.MINI;
    public CardMapper<Pic> get(Type type) {
        switch (type) {
            case MICRO:return new MicroPicCardMapper();
            case MINI:return new MiniPicCardMapper();
            case SMALL:return new SmallPicCardMapper();
            case LARGE:return new LargePicCardMapper();
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
        MICRO,
        MINI,
        SMALL,
        LARGE
    }

}

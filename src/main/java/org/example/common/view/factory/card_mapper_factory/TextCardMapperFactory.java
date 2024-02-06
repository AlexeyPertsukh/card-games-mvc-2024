package org.example.common.view.factory.card_mapper_factory;

import org.example.common.view.card_mapper.*;

public class TextCardMapperFactory implements CardMapperFactory<String> {
    private static final Type DEFAULT = Type.BASIC;
    public CardMapper<String> get(Type type) {
        switch (type) {
            case BASIC:return new TextCardMapper();
            default: throw new IllegalArgumentException("unsupported card mapper type: " + type);
        }
    }

    @Override
    public CardMapper<String> get(int value) {
        Type type = Type.values()[value];
        return get(type);
    }

    @Override
    public CardMapper<String> get(String value) {
        Type type = Type.valueOf(value);
        return get(type);
    }

    @Override
    public CardMapper<String> get() {
        return get(DEFAULT);
    }

    public enum Type {
        BASIC
    }

}

package org.example.common.view.factory.card_mapper_factory;

import org.example.common.view.card_mapper.CardMapper;

import java.util.function.Supplier;

public interface CardMapperFactory<T>  {
    CardMapper<T> get(int value);
    CardMapper<T> get(String value);
    CardMapper<T> get();

}

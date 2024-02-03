package org.example.controller;

public class InfoFactory {
    private static final String[] TITTLE = {
            "**************",
            "  BLACK JACK  ",
            "**************",
    };
    private static InfoFactory factory;
    private InfoFactory() {
    }

    public static InfoFactory getInstance() {
        if(factory == null) {
            factory = new InfoFactory();
        }
        return factory;
    }

    String[] tittle() {
        return TITTLE;
    }


}

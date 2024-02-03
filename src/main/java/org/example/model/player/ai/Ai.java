package org.example.model.player.ai;

public interface Ai {

    Cmd input(int point);

    enum Cmd {
        TAKE,
        SKIP;
    }
}

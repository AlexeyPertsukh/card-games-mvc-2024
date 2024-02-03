package org.example.model.player.ai;

public class DealerAi implements Ai{
    private final static int SKIP_POINT = 17;
    @Override
    public Cmd input(int point) {
        if(point < SKIP_POINT) {
            return Cmd.TAKE;
        }
        return Cmd.SKIP;
    }
}

package org.example.common.model.player.bot;

public class DealerAi implements Ai{
    private final static int SKIP_POINT = 17;
    @Override
    public Bot.BotCommand input(int point) {
        if(point < SKIP_POINT) {
            return Bot.BotCommand.TAKE;
        }
        return Bot.BotCommand.SKIP;
    }
}

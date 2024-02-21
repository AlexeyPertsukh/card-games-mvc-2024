package org.example.guess_card.model.storage;

import org.example.common.model.player.Player;

public class GcStorage extends AbstractStorage<GcStorage.Data> {
    public GcStorage() {
    }

    @Override
    protected Data defaultData(Player player) {
        return new Data(player);
    }


    public static class Data {
        private final Player player;
        private int point;

        public Data(Player player) {
            this.player = player;
        }

        public Player getPlayer() {
            return player;
        }

        public int getPoint() {
            return point;
        }

        public void addPoint(int num) {
            point += num;
        }
    }

}

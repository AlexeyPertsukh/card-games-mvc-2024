package org.example.black_jack.controller.starter;

public class Main_2p1b_Mini5x3Pic_color {
    private static final String PLAYER_NUM = "2";
    private static final String BOT_NUM = "1";
    private static final String CARD_PIC = MainMasterConfig.picMini5x3();
    private static final String COLOR = MainMasterConfig.ColorType.COL.name();

    public static void main(String[] args) {
        MainMasterConfig.main(PLAYER_NUM, BOT_NUM, COLOR, CARD_PIC);
    }
}
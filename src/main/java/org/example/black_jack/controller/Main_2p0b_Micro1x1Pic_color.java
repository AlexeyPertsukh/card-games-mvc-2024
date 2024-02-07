package org.example.black_jack.controller;

public class Main_2p0b_Micro1x1Pic_color {
    private static final String PLAYER_NUM = "2";
    private static final String BOT_NUM = "0";
    private static final String CARD_PIC = MainConfig.picMicro1x1();
    private static final String COLOR = MainConfig.ColorType.COL.name();

    public static void main(String[] args) {
        MainConfig.main(PLAYER_NUM, BOT_NUM, COLOR, CARD_PIC);
    }
}
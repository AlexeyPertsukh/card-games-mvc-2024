package org.example.black_jack.controller;

public class Main_4p0b_Mini5x3Pic_color {
    private static final String PLAYER_NUM = "4";
    private static final String BOT_NUM = "0";
    private static final String CARD_PIC = MainConfig.picMini5x3();
    private static final String COLOR = MainConfig.ColorType.COL.name();

    public static void main(String[] args) {
        MainConfig.main(PLAYER_NUM, BOT_NUM, COLOR, CARD_PIC);
    }
}
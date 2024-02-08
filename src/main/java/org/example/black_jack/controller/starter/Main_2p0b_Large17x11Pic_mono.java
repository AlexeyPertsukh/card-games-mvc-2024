package org.example.black_jack.controller.starter;

public class Main_2p0b_Large17x11Pic_mono {
    private static final String PLAYER_NUM = "2";
    private static final String BOT_NUM = "0";
    private static final String CARD_PIC = MainMasterConfig.picLarge17X11();
    private static final String COLOR = MainMasterConfig.ColorType.MONO.name();


    public static void main(String[] args) {
        MainMasterConfig.main(PLAYER_NUM, BOT_NUM, COLOR, CARD_PIC);
    }
}
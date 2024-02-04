package org.example.view.views.group_player_data_view;

import org.example.model.Deck;
import org.example.model.card.Card;
import org.example.model.player.bot.Bot;
import org.example.model.player.Player;
import org.example.model.game.PlayerStatus;
import org.example.model.game.PlayerData;
import org.example.view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TextListPlayerDataView extends ListPlayerDataView<String> {
    public TextListPlayerDataView(Printer printer, Function<Card, String> map) {
        super(printer, map);
    }

    @Override
    public void show(List<PlayerData> dataList) {
        if (dataList.size() == 0) {
            return;
        }

        String[] pic = null;
        int cardLines = maxCardLine(dataList);

        for (PlayerData data : dataList) {
            String[] current = page(cardLines, data);

            if (pic == null) {
                pic = combine(new String[]{""}, current);
            } else {
                pic = combine(pic, current);
            }
        }
        show(pic);
    }

    private static String[] combine(String[] first, String[] second) {
        String template = "%s%-20s";

        int max = Math.max(first.length, second.length);
        String[] out = new String[max];
        for (int i = 0; i < max; i++) {

            String firstText = first.length > i ? first[i] : "";
            String secondText = second.length > i ? second[i] : "";

            out[i] = String.format(template, firstText, secondText);
        }
        return out;
    }

    private void show(String[] strings) {
        for (String s : strings) {
            printer.out(s);
        }
    }

    private String[] page(int cardLines, PlayerData data) {

        Player player = data.getPlayer();
        Deck deck = data.getDeck();
        PlayerStatus state = data.getStatus();
        int point = data.getPoint();

        List<Card> cards = deck.toList();

        List<String> strings = new ArrayList<>();
        String name = player.getName();
        if(player instanceof Bot) {
            name+="[bot]";
        }
        strings.add(name);
        strings.add("------");


        int line = 0;
        while (line < cardLines) {
            if (cards.size() > line) {
                String text = map.apply(cards.get(line));
                strings.add(text);
            } else {
                strings.add("");
            }
            line++;
        }

        strings.add("------");
        String pointMessage = data.isCardsOpen() ? String.valueOf(point) : "???";

        strings.add("Points: " + pointMessage);
        strings.add(textState(data.getStatus()));
        return strings.toArray(new String[0]);
    }

    private static int maxCardLine(List<PlayerData> dataList) {
        int max = 0;
        for (PlayerData data : dataList) {
            if (data.getDeck().size() > max) {
                max = data.getDeck().size();
            }
        }
        return max;
    }

    private static String textState(PlayerStatus state) {
        switch (state) {
            case BLACK_JACK: return "BLACK JACK";
            case BUST: return "BUST";
            case LOSE: return "LOSE";
            case WIN: return "WIN";
            case IN_GAME: return "in game";
            default: throw new IllegalArgumentException("illegal game state: " + state);
        }
    }
}

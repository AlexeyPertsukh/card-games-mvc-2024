package org.example.view.views.group_player_view;

import org.example.model.Deck;
import org.example.model.DeckStorage;
import org.example.model.card.Card;
import org.example.view.Player;
import org.example.view.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BjTextDeckStorageView extends DeckStorageView<String> {
    private final Function<Deck, Integer> pointCalculate;

    public BjTextDeckStorageView(Printer printer, Function<Card, String> map, Function<Deck, Integer> pointCalculate) {
        super(printer, map);
        this.pointCalculate = pointCalculate;
    }


    @Override
    public void show(DeckStorage storage) {
        if(storage.size() == 0) {
            return;
        }

        List<Player> players = storage.players();
        int maxCardLines = maxSize(storage.decks());

        String[] pic = null;
        for (Player player : players) {

            Deck deck = storage.get(player);

            String[] current = page(player, deck, maxCardLines);

            if (pic == null) {
                pic = combine(new String[] {""}, current);
            } else {
                pic = combine(pic, current);
            }

        }

        for (String s : pic) {
            printer.out(s);
        }

    }

    private int maxSize(List<Deck> decks) {
        int max = 0;
        for (Deck deck : decks) {
            if (deck.size() > max) {
                max = deck.size();
            }
        }
        return max;
    }

    private String[] page(Player player, Deck deck, int maxLines) {
        List<Card> cards = deck.toList();

        List<String> strings = new ArrayList<>();
        strings.add(player.getName());
        strings.add("------");


        int line = 0;
        while (line < maxLines) {
            if (cards.size() > line) {
                String text = map.apply(cards.get(line));
                strings.add(text);
            } else {
                strings.add("");
            }
            line++;
        }

        strings.add("------");
        String pointMessage = "???";
        if (isOpen(deck)) {
            int point = pointCalculate.apply(deck);
            pointMessage = String.valueOf(point);
        }
        strings.add("Points: " + pointMessage);
        return strings.toArray(new String[0]);
    }

    private static boolean isOpen(Deck deck) {
        for (Card card : deck.toList()) {
            if (!card.isOpen()) {
                return false;
            }
        }
        return true;
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


}

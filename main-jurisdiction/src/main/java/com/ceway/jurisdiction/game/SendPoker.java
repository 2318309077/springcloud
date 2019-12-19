package com.ceway.jurisdiction.game;

import java.util.List;

public class SendPoker {
    // Player[] players = new Player[4];

    public Player[] sendPoker(Player[] ps, List washedCards) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Poker temp = new Poker();
                temp = (Poker) washedCards.get(i * 4 + j);
                ps[i].setOneOfPocket(j, temp);
            }
        }
        return ps;
    }
}
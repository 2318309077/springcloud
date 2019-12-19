package com.ceway.jurisdiction.game;

public class Dealer {
    public Player getDealer(Player[] players){
        int index = (int)(Math.random() * players.length);
        return players[index];
    }
}

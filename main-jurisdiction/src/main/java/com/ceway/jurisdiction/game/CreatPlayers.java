package com.ceway.jurisdiction.game;

import java.util.Arrays;

public class CreatPlayers {
    Player[] players =new Player[4];    //建立四个玩家

    public CreatPlayers() {
        players[0] = new Player("张钰洁");
        players[1] = new Player("周颜颖");
        players[2] = new Player("毛繁宇");
        players[3] = new Player("李慧敏");
    }
    public Player[] getPlayers(){
        return players;
    }
    @Override
    public String toString() {
        return "CreatPlayers [players=" + Arrays.toString(players) + "]";
    }



}

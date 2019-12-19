package com.ceway.jurisdiction.game;

import java.util.Arrays;

public class Player {
    private String name;
    private Poker[] pocket = new Poker[5]; // 玩家手上的5张牌
    private Boolean isBull = false; // 手牌是否有牛
    private int pointOfBull; // 牛几
    private Poker biggestCard; // 最大的是哪张牌
    public Player() {
        super();
    }
    public Player(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Poker[] getPocket() {
        return pocket;
    }
    public void setPocket(Poker[] pocket) {
        this.pocket = pocket;
    }
    public void setOneOfPocket(int index, Poker poker) {
        this.pocket[index] = poker;
    }
    public Poker getOneOfPocket(int index) {
        return pocket[index];
    }
    public Boolean getIsBull() {
        return isBull;
    }
    public void setIsBull(Boolean isBull) {
        this.isBull = isBull;
    }
    public int getPointOfBull() {
        return pointOfBull;
    }
    public void setPointOfBull(int pointOfBull) {
        this.pointOfBull = pointOfBull;
    }

    public Poker getBiggestCard() {
        return biggestCard;
    }
    public void setBiggestCard(Poker biggestCard) {
        this.biggestCard = biggestCard;
    }
    public Poker getIndexOfPoker(int index) {
        return pocket[index];
    }
    @Override
    public String toString() {
        return name + "的手牌为" + Arrays.toString(pocket);
    }


    public  Poker getBiggestCards(Poker[] pocket) { // 获取手牌中的最大牌:有个问题没解决，如果出现点数相同，花色不同
        Poker poker = new Poker();
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (pocket[i].getCount() > count) {
                poker = pocket[i];
                count = pocket[i].getCount();
            }
        }
        return poker;
//		System.out.println(poker);
//		System.out.println(this.getBiggestCard());
    }

}
package com.ceway.jurisdiction.game;

import java.util.ArrayList;
import java.util.List;

//建好52张按照默认排序的牌
public class CreatPoker {
    private List cardsAll = new ArrayList();
    private static final String[] colors = { "黑桃", "红桃", "梅花", "方块" };
    private static final String[] points = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    public CreatPoker() {
//		StringBuffer c = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardsAll.add(new Poker(colors[i] , points[j]));
            }
        }
    }
    public List getCardsAll(){
        return cardsAll;
    }
}
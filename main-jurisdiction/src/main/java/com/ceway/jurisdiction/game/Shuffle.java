package com.ceway.jurisdiction.game;

import java.util.Collections;
import java.util.List;
//洗牌
public class Shuffle {
    List washedCards;
    public Shuffle(List cardsAll){
        washedCards = cardsAll;
        Collections.shuffle(washedCards);
    }
    public List getWashedCards(){
        return washedCards;
    }
}

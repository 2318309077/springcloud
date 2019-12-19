package com.ceway.jurisdiction.game;


public  class Compare {
    public static void isBull(Player player) { // 判断手牌手否有牛
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    if ((player.getIndexOfPoker(i).getPoints()
                            + player.getIndexOfPoker(j).getPoints()
                            + player.getIndexOfPoker(k).getPoints()) % 10 == 0) {
                        player.setIsBull(true); // 如果玩家手中的任意三张牌之和是10的倍数，则有牛
                    }
                }
            }
        }
    }
    public static void pointOfBull(Player player) { // 判断手牌为牛几
        int allPoints = 0; // 五张牌的总点数
        for (int i = 0; i < 5; i++) {
            allPoints += player.getIndexOfPoker(i).getPoints();
        }

        player.setPointOfBull(allPoints % 10);
    }
    public Player compare(Player p1, Player p2) {
        if (p1.getIsBull() && p2.getIsBull()) {
            if (p1.getPointOfBull() > p2.getPointOfBull()) { // 如果谁牛的点数大，就返回谁
                return p1;
            } else if (p1.getPointOfBull() < p2.getPointOfBull()) {
                return p2;
            } else {                                   // 如果牛的点数相同，则比较最大牌
                if (p1.getBiggestCard().getCount() > p2.getBiggestCard().getCount()) {
                    return p1;
                } else {
                    return p2;
                }
            }
        }else{
            return null;
        }

    }


}

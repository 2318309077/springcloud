package com.ceway.jurisdiction.game;

public class View {
    Player player = new Player();
    public void view(Player[] players) {
        for (int j = 0; j < 4; j++) {
            System.out.print(players[j].getName() + "的牌为：");
            for (int i = 0; i < 5; i++) {
                System.out.print(players[j].getOneOfPocket(i) + "\t");
            }
            // System.out.println(players[j].getIsBull());
            if ((players[j].getIsBull() == true) && (players[j].getPointOfBull() != 0)) {
                System.out.println(" 【牛" + players[j].getPointOfBull() + "】"  + ": 最大的牌是"
                        + player.getBiggestCards(players[j].getPocket()).getColor()
                        + player.getBiggestCards(players[j].getPocket()).getPoint());
            } else if((players[j].getIsBull() == true) &&  (players[j].getPointOfBull() == 0)){
                System.out.println(" 【牛牛】"  + ": 最大的牌是"
                        + player.getBiggestCards(players[j].getPocket()).getColor()
                        + player.getBiggestCards(players[j].getPocket()).getPoint());
            }else{

                System.out.println("   没牛：最大的牌是" + player.getBiggestCards(players[j].getPocket()).getColor()
                        + player.getBiggestCards(players[j].getPocket()).getPoint());
            }
        }
    }
}

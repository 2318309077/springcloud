package com.ceway.jurisdiction.game;

import java.util.List;

public class Bull {
    private static CreatPlayers cplayers;
    private static CreatPoker cpoker;
    private static Shuffle shuffle;
    private static SendPoker spoker; // 发牌
    private static View view;
    private static Player dealer; // 庄家
    private static List washedCards; // 洗过的牌
    private static Player[] players0; // 建好的玩家
    private static Player[] players1; // 发好牌的玩家

    public static void main(String[] args) {
        System.out.println("欢迎来到文字牛牛游戏");
        System.out.println("正在建牌中，请稍等");
        cpoker = new CreatPoker(); // 牌已经建好
        List cardsAll = cpoker.getCardsAll(); // 一、获取建好的牌
        int flag = 0;
        for (Object obj : cardsAll) {
            if (flag++ % 13 == 0) {
                System.out.println();
            }
            System.out.print(obj + " ");
        }
        shuffle = new Shuffle(cardsAll); // 二、洗牌
        washedCards = shuffle.getWashedCards(); // 三、获取一副洗好了的牌
        cplayers = new CreatPlayers(); // 四、创建玩家
          players0 = cplayers.getPlayers();
//        System.out.println(players0[1]); //检验是否建立好玩家
        dealer = new Dealer().getDealer(players0); // 五、从四名玩家中选出一名庄家
        System.out.println("\n\n" + "本局庄家是:" + dealer.getName() + " " + "\n\n");
        spoker = new SendPoker(); // 发牌
        players1 = spoker.sendPoker(players0, washedCards); // 牌发完
        Player player = new Player();
        for (int i = 0; i < 4; i++) {
            player.getBiggestCards(players1[i].getPocket());
             System.out.println(players1[i].getOneOfPocket(3));
             System.out.println(player.getBiggestCards(players1[i].getPocket()));
        }
        for (int i = 0; i < 4; i++) {
            Compare.pointOfBull(players1[i]);
            Compare.isBull(players1[i]);
             System.out.println(players1[i].getPointOfBull());
        }
        view = new View();
        view.view(players1);
    }
}

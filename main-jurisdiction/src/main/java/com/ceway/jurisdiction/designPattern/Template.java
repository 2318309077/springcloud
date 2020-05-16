package com.ceway.jurisdiction.designPattern;

/**
 * @author 伍金亮
 * @version 模版方法 固定执行的方法模版  可以使用不同的方法进行实例化
 * @date 2020/5/16 3:34 下午
 */
public class Template {
    public static void main(String[] args) {
        Game game1 = new Cricket1();
        Game game2 = new Cricket2();
        game1.play();
        game2.play();
    }
}
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
class Cricket1 extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket1======endPlay");
    }

    @Override
    void initialize() {
        System.out.println("Cricket1======initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket1======startPlay");
    }
}
class Cricket2 extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket2======endPlay");
    }

    @Override
    void initialize() {
        System.out.println("Cricket2======initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket2======startPlay");
    }
}
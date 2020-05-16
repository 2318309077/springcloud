package com.ceway.jurisdiction.designPattern;

/**
 * @author 伍金亮
 * @version 策略模式 拥有共同特点 把不同之处分离出来实现
 * @date 2020/5/16 1:47 下午
 */
public class Strategy {
    public static void main(String[] args) {
        Strategys strategys =new Operation1();
        Context context = new Context(strategys);
        context.executeStrategy(1,2);
    }
}
interface Strategys {
    public int doOperation(int num1, int num2);
}
class Operation1 implements Strategys{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
class Operation2 implements Strategys{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
class Operation3 implements Strategys{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
class Context {
    private Strategys strategy;

    public Context(Strategys strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(int num1, int num2){
        strategy.doOperation(num1,num2);
    }

}
package com.ceway.jurisdiction.designPattern;

/**
 * @author 伍金亮
 * @version 责任链模式   通过链表进行对其任务的顺序执行
 * @date 2020/5/16 12:03 下午
 */
public class Responsibility {
    public static void main(String[] args) {
        AbstractLogger consoleLogger1 = new ConsoleLogger1(1);
        AbstractLogger consoleLogger2 = new ConsoleLogger2(2);
        AbstractLogger consoleLogger3 = new ConsoleLogger3(3);
        consoleLogger1.addNextLogger(consoleLogger2);
        consoleLogger2.addNextLogger(consoleLogger3);
        consoleLogger1.logMessage(3,"执行方法");
    }
}
//定义链表数据结构与执行方法
abstract class  AbstractLogger{
    //责任链执行顺序值
    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    //添加责任链
    public void addNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }
    //执行方法调用
    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }
    //责任链执行方法
    protected abstract void write(String message);
}
class ConsoleLogger1 extends AbstractLogger {

    public ConsoleLogger1(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console:执行方法========ConsoleLogger1: " + message);
    }
}
class ConsoleLogger2 extends AbstractLogger {

    public ConsoleLogger2(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console:执行方法========ConsoleLogger2: " + message);
    }
}
class ConsoleLogger3 extends AbstractLogger {

    public ConsoleLogger3(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console:执行方法========ConsoleLogger3: " + message);
    }
}

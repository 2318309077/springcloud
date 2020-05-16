package com.ceway.jurisdiction.designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 伍金亮
 * @version 观察者模式  把执行方法存入集合中对其进行操作
 * @date 2020/5/15 10:03 下午
 */
public class Observation {
    public static void main(String[] args) {
        Observer observer1 = new Task1();
        Observer observer2 = new Task2();
        Subject sub = new Subject();
        sub.addObservers(observer1);
        sub.addObservers(observer2);
        sub.notifyAllObservers(2);
    }
}
class  Subject{

     private List<Observer>  observers = new ArrayList<Observer>();

     public void  addObservers(Observer observer){
         observers.add(observer);
     }

     public  void  deleteObservers(Observer observer){
         observers.remove(observer);
     }

     public void  notifyAllObservers(int start){
         for (Observer observer : observers) {
             observer.update(start);
         }
     }
}

interface Observer{
    public  void  update(int number);
}

class Task1 implements  Observer{
    @Override
    public void update(int number) {
        System.out.println("Task1=============="+(number+1));
    }
}

class Task2 implements  Observer{
    @Override
    public void update(int number) {
        System.out.println("Task2=============="+(number-1));
    }
}

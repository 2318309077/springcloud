package com.ceway.esAndCanal.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import sun.misc.Unsafe;

public class Main {
	private volatile static Integer num1;
    private volatile static Integer num2;
    private static Integer num3;
    private static final int c = 100;

    public static void main(String[] args) throws Throwable {
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        ArrayList<Object> list3 = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            num1 = 300;
            num2 = 300;
            num3 = 300;

            //没有cas
            CountDownLatch t1 = new CountDownLatch(c);
            for (int i = c; i > 0; i--) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        num1++;
                        t1.countDown();
                    }
                }).start();
            }
            t1.await();
            list1.add(num1);

            //cas
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe)f.get(null);
            Long valueOffset = unsafe.objectFieldOffset
                (Integer.class.getDeclaredField("value"));
            CountDownLatch t2 = new CountDownLatch(c);
            for (int i = c; i > 0; i--) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int intVolatile;
                        do {
                            intVolatile = unsafe.getIntVolatile(num2, valueOffset);
                        } while (!unsafe.compareAndSwapInt(num2, valueOffset, intVolatile, intVolatile + 1));
                        //compareAndSwapInt(哪个对象，对象中的偏移量，初始值，期望值)
                        t2.countDown();
                    }
                }).start();
            }
            t2.await();
            list2.add(num2);

            //synchronized
            CountDownLatch t3 = new CountDownLatch(c);
            for (int i = c; i > 0; i--) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (num3) {
                            num3++;
                        }
                        t3.countDown();
                    }
                }).start();
            }
            t3.await();
            list3.add(num2);
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

}

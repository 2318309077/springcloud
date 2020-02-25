package com.ceway.jurisdiction.springboot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class theadchi implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(Thread.currentThread().getName()+ ":" + x);
        }
    }

    public static void main(String[] args) {
        // 创建一个线程池对象，控制要创建几个线程对象。
        // public static ExecutorService newFixedThreadPool(int nThreads)
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 可以执行Runnable对象或者Callable对象代表的线程
        pool.submit(new theadchi());
        pool.submit(new theadchi());

        //结束线程池
        pool.shutdown();
    }
}

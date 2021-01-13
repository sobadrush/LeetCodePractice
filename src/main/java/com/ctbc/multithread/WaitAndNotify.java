package com.ctbc.multithread;

import java.util.concurrent.TimeUnit;

public class WaitAndNotify {

    static class MyThread extends Thread {

        private String name;
        private Object co; // 鎖

        public MyThread(String name, Object o) {
            this.name = name;
            this.co = o;
        }

        @Override
        public void run() {
            try {
                synchronized (co) {
                    System.out.println(" >>> 搶到鎖的執行續是: " + Thread.currentThread().getName());
                    System.out.println(name + " is waiting.");
                    co.wait(); // 搶到鎖的執行續直接 wait()
                }
                System.out.println(name + " has been notified.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Object co = new Object(); // 鎖
        System.out.println(co);

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread" + i, co); // 建立5個執行續
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("-----Main Thread notify-----");

            // Main-Thread 呼叫 notifyAll : 可以喚醒所有處於 wait 狀態的線程，使其重新進入鎖的爭奪隊列中
            // Main-Thread 呼叫 notify : notify只能喚醒一個
            synchronized (co) {
                // co.notify();
                co.notifyAll();
            }

            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread is end.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
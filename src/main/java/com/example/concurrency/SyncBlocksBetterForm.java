package com.example.concurrency;

public class SyncBlocksBetterForm {
    public static int count1 =0;
    public static int count2 =0;

    private final static Object lock1 = new Object();
    private final static Object lock2 = new Object();

    public static void add() {
        synchronized (lock1) {
            count1++;
        }

    }

    public synchronized static void addAgain() {
        synchronized (lock2) {
            count2++;
        }
    }

    public static void compute() {
        for(int i=0;i< 100;i++) {
            add();
            addAgain();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() { compute(); }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() { compute(); }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("count1: " + count1 + " count2:" + count2);
    }
}
